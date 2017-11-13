
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.zip.*;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class CompressorStream extends SwingWorker<Boolean, Chunk> {

    private final int BUFFER_SIZE = 1000;
    private final JProgressBar totalBar;
    private final JProgressBar fileBar;
    private final JTextArea area;
    private List<File> files = null;
    private String destination = null;
    private int remaining;

    public CompressorStream(JProgressBar totalBar, JTextArea area, JProgressBar fileBar) {
        this.totalBar = totalBar;
        this.area = area;
        this.fileBar = fileBar;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        try {
            //Inicializamos contadores
            totalBar.setMaximum(files.size());

            // Objeto para referenciar a los archivos que queremos comprimir
            BufferedInputStream origin = null;

            // Objeto para referenciar el archivo zip de salida
            FileOutputStream dest = new FileOutputStream(destination);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

            // Buffer de transferencia para mandar datos a comprimir
            byte[] data = new byte[BUFFER_SIZE];
            Iterator<File> i = files.iterator();
            int actualFile = 0;
            while (i.hasNext() && !isCancelled()) {
                // Update status
                File next = i.next();
                String filename = next.getAbsolutePath();
                publish(new Chunk(next.getName(), false, actualFile));

                FileInputStream fi = new FileInputStream(filename);
                origin = new BufferedInputStream(fi, BUFFER_SIZE);

                ZipEntry entry = new ZipEntry(next.getName());
                out.putNextEntry(entry);
                // Leemos datos desde el archivo origen y los mandamos al archivo destino
                fileBar.setMaximum((int) next.length());
                fileBar.setValue(0);
                int count;
                int actualFileProcessed = 0;
                while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1 && !isCancelled()) {
                    out.write(data, 0, count);
                    publish(new Chunk(filename, true, actualFileProcessed += count));
                }
                // Cerramos el archivo origen, ya enviado a comprimir
                origin.close();
                actualFile++;
            }
            // Cerramos el archivo zip
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void process(List<Chunk> chunks) {
        if (isCancelled()) {
            return;
        }
        for (Chunk chunk : chunks) {
            if (chunk.isInFile()) {
                fileBar.setValue(chunk.getActual());
                double progress = chunk.getActual() /(double) fileBar.getMaximum();
                double percentage = 100 * (progress);
                DecimalFormat dc = new DecimalFormat("0.00");
                fileBar.setString(dc.format(percentage) + "%");
            } else {
                totalBar.setValue(chunk.getActual());
                double percentage = 100 * (chunk.getActual()) / ((double) files.size());
                DecimalFormat dc = new DecimalFormat("0.00");
                totalBar.setString(dc.format(percentage) + "%");
                area.append("Compressing -- " + chunk.getFilename() + "\n");
            }
        }
    }

    @Override
    protected void done() {
        if (!isCancelled()) {
            totalBar.setValue(totalBar.getMaximum());
            totalBar.setString("100%");
            fileBar.setValue(fileBar.getMaximum());
            fileBar.setString("100%");
            area.append("Compression -- DONE");
        }else{
            totalBar.setStringPainted(false);
            fileBar.setStringPainted(false);
            area.append("Process cancelled");
        }
        area.setEnabled(false);
    }

    public final void compress(List<File> files, String destPath) {
        this.files = files;
        this.destination = destPath;
        this.execute();
    }

}

class Chunk {

    private final String filename;
    private final boolean inFile;
    private final int actual;

    public String getFilename() {
        return filename;
    }

    public boolean isInFile() {
        return inFile;
    }

    public int getActual() {
        return actual;
    }

    public Chunk(String filename, boolean inFile, int remaining) {
        this.filename = filename;
        this.inFile = inFile;
        this.actual = remaining;
    }
}
