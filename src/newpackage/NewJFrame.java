package newpackage;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import zarema_rmi_client_server.Variables;
import zarema_rmi_client_server.IRemoteSolution;
import java.awt.Color;

/**
 *
 * @author Зарема
 */
public class NewJFrame extends javax.swing.JFrame {
    private Registry registry = null;
    private IRemoteSolution remoteServer = null;
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPrimer = new javax.swing.JLabel();
        jLabelA = new javax.swing.JLabel();
        jLabelB = new javax.swing.JLabel();
        jLabelX = new javax.swing.JLabel();
        jLabelResult = new javax.swing.JLabel();
        jTextFieldA = new javax.swing.JTextField();
        jTextFieldB = new javax.swing.JTextField();
        jTextFieldX = new javax.swing.JTextField();
        jButtonClear = new javax.swing.JButton();
        jButtonSolve = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Визуальная клиент-серверная программа на Java на основе технологии RMI.");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabelPrimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/5variant.JPG"))); // NOI18N
        getContentPane().add(jLabelPrimer);
        jLabelPrimer.setBounds(20, 50, 550, 220);

        jLabelA.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        jLabelA.setText("Введите a = ");
        getContentPane().add(jLabelA);
        jLabelA.setBounds(20, 290, 120, 24);

        jLabelB.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        jLabelB.setText("Введите b = ");
        getContentPane().add(jLabelB);
        jLabelB.setBounds(20, 320, 120, 24);

        jLabelX.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        jLabelX.setText("Введите x = ");
        getContentPane().add(jLabelX);
        jLabelX.setBounds(20, 350, 120, 24);

        jLabelResult.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabelResult.setText("Ответ: y = ");
        getContentPane().add(jLabelResult);
        jLabelResult.setBounds(300, 370, 210, 24);

        jTextFieldA.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextFieldA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldA);
        jTextFieldA.setBounds(130, 290, 80, 25);

        jTextFieldB.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        getContentPane().add(jTextFieldB);
        jTextFieldB.setBounds(130, 320, 80, 25);

        jTextFieldX.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        getContentPane().add(jTextFieldX);
        jTextFieldX.setBounds(130, 350, 80, 25);

        jButtonClear.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButtonClear.setText("Очистить");
        jButtonClear.setName(""); // NOI18N
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClear);
        jButtonClear.setBounds(400, 310, 160, 50);

        jButtonSolve.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButtonSolve.setText("Решить");
        jButtonSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSolveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSolve);
        jButtonSolve.setBounds(220, 310, 160, 50);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Вариант 5");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 0, 180, 50);
        jLabel1.getAccessibleContext().setAccessibleName("Визуальная клиент-серверная программа на Java на основе технологии RMI для распределенного расчета математического значения по заданному алгоритму.");

        setSize(new java.awt.Dimension(604, 445));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTextFieldA.setText("");
        jTextFieldB.setText("");
        jTextFieldX.setText("");
        jLabelResult.setText("Ответ: y = ");
        jLabelResult.setForeground(Color.black);
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSolveActionPerformed
        try {

            int port = IRemoteSolution.PORT;
            String name = IRemoteSolution.SERVICE_NAME;
            String address = "localhost";
            if (registry == null || remoteServer == null) {
                System.out.println("Подключение...");
                registry = LocateRegistry.getRegistry(address, port);
                //ystem.out.println("Подключение2...");
                remoteServer = (IRemoteSolution) registry.lookup(name);
                System.out.println("Подключено к //" + address + ":" + port + "/" + name);
            }

            double a = Double.parseDouble(jTextFieldA.getText());
            double b = Double.parseDouble(jTextFieldB.getText());
            double x = Double.parseDouble(jTextFieldX.getText());
            Variables data = new Variables(a, b, x);
            data = (Variables) remoteServer.getData(data);

            jLabelResult.setText(String.format("Ответ: y = %.3f", data.getY()));
            jLabelResult.setForeground(Color.BLACK);
        } catch (NumberFormatException | NotBoundException | RemoteException e) {
            jLabelResult.setText("Ошибка");
            jLabelResult.setForeground(Color.red);
        }
    }//GEN-LAST:event_jButtonSolveActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSolve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelA;
    private javax.swing.JLabel jLabelB;
    private javax.swing.JLabel jLabelPrimer;
    private javax.swing.JLabel jLabelResult;
    private javax.swing.JLabel jLabelX;
    private javax.swing.JTextField jTextFieldA;
    private javax.swing.JTextField jTextFieldB;
    private javax.swing.JTextField jTextFieldX;
    // End of variables declaration//GEN-END:variables
}