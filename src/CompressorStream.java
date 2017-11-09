
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.*;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class CompressorStream extends SwingWorker<Object, Object> {

    private final int BUFFER_SIZE = 200;
    private final JProgressBar bar;
    private final JLabel label;
    private final List files;

    public CompressorStream(JProgressBar bar, JLabel label, List files) {
        this.bar = bar;
        this.label = label;
        this.files = files;
    }


    @Override
    protected Object doInBackground() throws Exception {
        try {
            // Objeto para referenciar a los archivos que queremos comprimir
            BufferedInputStream origin = null;
            // Objeto para referenciar el archivo zip de salida
            FileOutputStream dest = new FileOutputStream("c:\\folder.zip");
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            // Buffer de transferencia para mandar datos a comprimir
            byte[] data = new byte[BUFFER_SIZE];
            Iterator i = files.iterator();
            while (i.hasNext()) {
                String filename = (String) i.next();
                FileInputStream fi = new FileInputStream(filename);
                origin = new BufferedInputStream(fi, BUFFER_SIZE);

                ZipEntry entry = new ZipEntry(filename);
                out.putNextEntry(entry);
                // Leemos datos desde el archivo origen y los mandamos al archivo destino
                int count;
                while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1) {
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

}
