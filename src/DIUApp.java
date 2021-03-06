
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Entrar
 */
public class DIUApp extends javax.swing.JFrame {

    private CompressorStream cS;
    private List<File> fileList;
    private final Dimension minimumFrameSizeCollapsed;
    private Dimension minimumFrameSizeExpanded;

    /**
     * Creates new form DIUApp
     */
    public DIUApp() {
        initComponents();
        try {
            this.setIconImage(ImageIO.read(new File("./src/icon/zipIcon.png")));
        } catch (IOException ex) {
            Logger.getLogger(DIUApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLocationRelativeTo(null);
        scrollPane.setVisible(false);
        minimumFrameSizeCollapsed = this.getMinimumSize();
        minimumFrameSizeExpanded = new Dimension(minimumFrameSizeCollapsed.width,
                minimumFrameSizeCollapsed.height + scrollPane.getHeight());
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        originTextField = new javax.swing.JTextField();
        originSelectionButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        destTextField = new javax.swing.JTextField();
        destSelectionButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        totalProgressBar = new javax.swing.JProgressBar();
        startButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        fileProgressBar = new javax.swing.JProgressBar();
        scrollPane = new javax.swing.JScrollPane();
        progressArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        seeMoreButton = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIU Compressor");
        setMinimumSize(new java.awt.Dimension(570, 400));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));

        originSelectionButton.setText("Select");
        originSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originSelectionButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Compess folder:");

        jLabel2.setText("in:");

        destSelectionButton.setText("Select");
        destSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destSelectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(originTextField)
                    .addComponent(destTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(destSelectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(originSelectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(originTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(originSelectionButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destSelectionButton)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        totalProgressBar.setToolTipText("Progress");

        startButton.setText("Start compression");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel compression");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        progressArea.setEditable(false);
        progressArea.setColumns(20);
        progressArea.setRows(5);
        progressArea.setText("Progress:");
        progressArea.setEnabled(false);
        scrollPane.setViewportView(progressArea);

        jLabel3.setText("File compression progress");

        jLabel4.setText("Overall progress");

        seeMoreButton.setText("See More");
        seeMoreButton.setPreferredSize(new java.awt.Dimension(85, 23));
        seeMoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeMoreButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalProgressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                    .addComponent(fileProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(seeMoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(fileProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seeMoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fileProgressBar, totalProgressBar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void originSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originSelectionButtonActionPerformed
        String path = getDirectoryPath();
        originTextField.setText(path);
    }//GEN-LAST:event_originSelectionButtonActionPerformed

    private void destSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destSelectionButtonActionPerformed
        String path = getDirectoryPath();
        destTextField.setText(path);
        totalProgressBar.setMaximum(5);
    }//GEN-LAST:event_destSelectionButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if (!checkInputData()) {
            return;
        }
        fileList = getFileList(originTextField.getText());
        if (fileList.isEmpty()) {
            showError("Origin folder is empty");
            return;
        }
        //fileList =  getFileList("C:\\Users\\Granfran\\Desktop\\Informática\\4º\\DIU\\practica 8\\a comprimir");
        cS = new CompressorStream(totalProgressBar, progressArea, fileProgressBar);
        cS.compress(fileList, getZipName(destTextField.getText(), fileList.get(0)));
        //cS.compress(fileList, getZipName("C:\\Users\\Granfran\\Desktop\\Informática\\4º\\DIU\\practica 8\\", fileList.get(0)));
        progressArea.setEnabled(true);
        progressArea.setText("");
        fileProgressBar.setStringPainted(true);
        totalProgressBar.setStringPainted(true);
        cancelButton.setEnabled(true);
        startButton.setEnabled(false);
    }//GEN-LAST:event_startButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        boolean cancel = cS.cancel(true);
        if (cancel) {
            fileProgressBar.setValue(0);
            totalProgressBar.setValue(0);
        }
        File file = new File(getZipName(destTextField.getText(), fileList.get(0)));
        file.delete();
        startButton.setEnabled(true);
        cancelButton.setEnabled(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void seeMoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeMoreButtonActionPerformed
        if (seeMoreButton.isSelected()) {
            scrollPane.setVisible(true);
            this.setMinimumSize(this.getSize());
            this.pack();
            this.setMinimumSize(minimumFrameSizeExpanded);
        } else {
            scrollPane.setVisible(false);
            this.setMinimumSize(new Dimension(this.getWidth(), 0));
            this.pack();
            this.setMinimumSize(minimumFrameSizeCollapsed);
        }
    }//GEN-LAST:event_seeMoreButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DIUApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DIUApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DIUApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DIUApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DIUApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton destSelectionButton;
    private javax.swing.JTextField destTextField;
    private javax.swing.JProgressBar fileProgressBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton originSelectionButton;
    private javax.swing.JTextField originTextField;
    private javax.swing.JTextArea progressArea;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JToggleButton seeMoreButton;
    private javax.swing.JButton startButton;
    private javax.swing.JProgressBar totalProgressBar;
    // End of variables declaration//GEN-END:variables

    private String getDirectoryPath() {
        JFileChooser fc = new JFileChooser("..");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        fc.setFileFilter(getDirectoryFilter());
        int open = fc.showOpenDialog(rootPane);
        if (open == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getPath();
        }
        return "";
    }

    private FileFilter getDirectoryFilter() {
        return new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Directories";
            }
        };
    }

    private List<File> getFileList(String path) {
        File root = new File(path);
        File[] files = root.listFiles();
        ArrayList<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (!file.isDirectory()) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    private String getZipName(String path, File file) {
        if (path.endsWith(".zip")) {
            return path;
        } else {
            return path + file.getName().split("\\.")[0] + ".zip";
        }
    }

    private void showError(String error) {
        JOptionPane.showMessageDialog(this,
                error,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private boolean checkInputData() {
        File origin = new File(originTextField.getText());
        File destination = new File(destTextField.getText());

        if (!origin.exists() || !origin.canRead()) {
            showError("Problem with origin folder. Doesn`t exists or doesn't have read permission");
            return false;
        }
        if (!destination.exists() || !destination.canWrite()) {
            showError("Problem with destination folder. Doesn`t exists or doesn't have write permission");
            return false;
        }
        if (origin.equals(destination)) {
            showError("Origin and destination folder should be different");
            return false;
        }
        return true;
    }
}
