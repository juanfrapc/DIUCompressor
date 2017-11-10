
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.zip.*;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class CompressorStream extends SwingWorker<Boolean, String> {

    private final int BUFFER_SIZE = 200;
    private final JProgressBar bar;
    private final JLabel label;
    private List<File> files = null;
    private String destination = null;
    private int remaining;

    public CompressorStream(JProgressBar bar, JLabel label) {
        this.bar = bar;
        this.label = label;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        try {
            //Inicializamos contadores
            remaining = files.size();
            bar.setMaximum(remaining);

            // Objeto para referenciar a los archivos que queremos comprimir
            BufferedInputStream origin = null;

            // Objeto para referenciar el archivo zip de salida
            FileOutputStream dest = new FileOutputStream(destination);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

            // Buffer de transferencia para mandar datos a comprimir
            byte[] data = new byte[BUFFER_SIZE];
            Iterator<File> i = files.iterator();
            while (i.hasNext() && !isCancelled()) {
                // Update status
                String filename = (String) i.next().getAbsolutePath();
                publish(filename);

                FileInputStream fi = new FileInputStream(filename);
                origin = new BufferedInputStream(fi, BUFFER_SIZE);

                ZipEntry entry = new ZipEntry(filename);
                out.putNextEntry(entry);
                // Leemos datos desde el archivo origen y los mandamos al archivo destino
                int count;
                while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1 && !isCancelled()) {
                    out.write(data, 0, count);
                }
                // Cerramos el archivo origen, ya enviado a comprimir
                origin.close();
            }
            // Cerramos el archivo zip
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String chunk : chunks) {
            System.out.println(remaining);
            bar.setValue(files.size() - remaining);
            float percentage = 100*(files.size() - remaining)/((float)files.size());
            DecimalFormat dc = new DecimalFormat("0.00");
            label.setText("Progress (" + dc.format(percentage) + "%): " + chunk);
            remaining--;
        }
    }

    @Override
    protected void done() {
        bar.setValue(bar.getMaximum());
        label.setText("Progress (100%): DONE");
    }

    public final void compress(List<File> files, String destPath) {
        this.files = files;
        this.destination = destPath;
        this.execute();
    }

}
