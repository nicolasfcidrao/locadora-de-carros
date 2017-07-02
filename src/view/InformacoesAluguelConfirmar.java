/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import persistence.AluguelDAO;
import persistence.AluguelMySqlDAO;
import persistence.CarroDAO;
import persistence.CarroMysqlDAO;
import util.DataUtil;

/**
 *
 * @author alexandre
 */
public class InformacoesAluguelConfirmar extends javax.swing.JFrame {

    public InformacoesAluguelConfirmar(Carro c) {
        this();
        labMostrarPlaca.setText(c.getPlaca());
        labMostrarCor.setText(c.getCor());
        labMostrarModelo.setText(c.getModelo());
        labMostrarDiaria.setText("" + c.getValor());
        labMostrarTrava.setText("" + c.isTrava());
        if (c.isTrava()) {
            labMostrarTrava.setText("Sim");
        } else {
            labMostrarTrava.setText("Não");
        }
        if (c.isArCondicionado()) {
            labMostrarAr.setText("Sim");
        } else {
            labMostrarAr.setText("Não");
        }
        labMostrarPorta.setText("" + c.getPortas());
        labMostrarVidro.setText("" + c.isVidro());
        if (c.isVidro()) {
            labMostrarVidro.setText("Sim");
        } else {
            labMostrarVidro.setText("Não");
        }
        labMostrarAuto.setText("" + c.isAutomatico());
        if (c.isAutomatico()) {
            labMostrarAuto.setText("Sim");
        } else {
            labMostrarAuto.setText("Não");
        }
        labMostrarDisponib.setText(c.getDisponibilidade());
        if (labMostrarDisponib.getText().equals("Livre")) {
            btnAlugar.setEnabled(true);
        } else {
            btnAlugar.setEnabled(false);
        }

    }

    public InformacoesAluguelConfirmar() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labMostrarPlaca = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labMostrarModelo = new javax.swing.JLabel();
        labMostrarCor = new javax.swing.JLabel();
        labMostrarPorta = new javax.swing.JLabel();
        labMostrarTrava = new javax.swing.JLabel();
        labMostrarAr = new javax.swing.JLabel();
        labMostrarVidro = new javax.swing.JLabel();
        labMostrarAuto = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboModoPagamento = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        labMostrarDiaria = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfRetirada = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        labMostrarDisponib = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAlugar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfDevolver = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Confirmacão de Aluguel e Reserva"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Placa: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        labMostrarPlaca.setText("//label com placa//");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 5);
        jPanel1.add(labMostrarPlaca, gridBagConstraints);

        jLabel3.setText("Modelo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Cor: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Trava: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 5);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Ar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Porta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Vidro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Automático:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel9, gridBagConstraints);

        labMostrarModelo.setText("//label com modelo do carro//");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(labMostrarModelo, gridBagConstraints);

        labMostrarCor.setText("//label com cor//");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(labMostrarCor, gridBagConstraints);

        labMostrarPorta.setText("//label com porta//");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(labMostrarPorta, gridBagConstraints);

        labMostrarTrava.setText("/label com trava(S/N)/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 5);
        jPanel1.add(labMostrarTrava, gridBagConstraints);

        labMostrarAr.setText("//label com ar(S/N)//");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(labMostrarAr, gridBagConstraints);

        labMostrarVidro.setText("//label com vidro(S/N)//");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(labMostrarVidro, gridBagConstraints);

        labMostrarAuto.setText("//label com automatico(S/N)//");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 2);
        jPanel1.add(labMostrarAuto, gridBagConstraints);

        jLabel17.setText("Modo de Pagamento: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        jPanel1.add(jLabel17, gridBagConstraints);

        comboModoPagamento.setMaximumRowCount(3);
        comboModoPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Cartão de Crédito", "Cartão de Débito" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
        jPanel1.add(comboModoPagamento, gridBagConstraints);

        jLabel18.setText("Diária: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel18, gridBagConstraints);

        labMostrarDiaria.setText("//label com preço da diaria//");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(labMostrarDiaria, gridBagConstraints);

        jLabel20.setText("Retirada:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel20, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(tfRetirada, gridBagConstraints);

        jLabel21.setText("Disponibilidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(jLabel21, gridBagConstraints);

        labMostrarDisponib.setText("//label com disponibilidade//");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(labMostrarDisponib, gridBagConstraints);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(btnCancelar, gridBagConstraints);

        btnAlugar.setText("Alugar");
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        jPanel1.add(btnAlugar, gridBagConstraints);

        jLabel2.setText("Devolução:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(tfDevolver, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Principal");

        jMenuItem5.setText("Retornar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem1.setText("Desconectar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Listar Carros");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        try {
            CarroMysqlDAO cDao = new CarroMysqlDAO();
            AluguelMySqlDAO aDao = new AluguelMySqlDAO();
            Aluguel a;

            String cpf = Sessao.usuarioLogado.getCpf();
            Date dataR = DataUtil.stringToDate(tfRetirada.getText());
            Date dataD = DataUtil.stringToDate(tfDevolver.getText());
            String pgto = (String) comboModoPagamento.getSelectedItem();
            String placa = labMostrarPlaca.getText();

            a = new Aluguel(cpf, dataR, dataD, pgto, placa);

            cDao.alugar(labMostrarPlaca.getText());
            aDao.inserir(a);

        } catch (ParseException ex) {
            Logger.getLogger(InformacoesAluguelConfirmar.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Carro alugado!");
        this.setVisible(false);
        LoginCliente lC = new LoginCliente();
        lC.setVisible(true);
    }//GEN-LAST:event_btnAlugarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaInicial tI = new TelaInicial();
        this.setVisible(false);
        tI.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        TelaInicial tI = new TelaInicial();
        this.setVisible(false);
        tI.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ListarCarros lC = new ListarCarros();
        setVisible(false);
        lC.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(InformacoesAluguelConfirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacoesAluguelConfirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacoesAluguelConfirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacoesAluguelConfirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacoesAluguelConfirmar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboModoPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labMostrarAr;
    private javax.swing.JLabel labMostrarAuto;
    private javax.swing.JLabel labMostrarCor;
    private javax.swing.JLabel labMostrarDiaria;
    private javax.swing.JLabel labMostrarDisponib;
    private javax.swing.JLabel labMostrarModelo;
    private javax.swing.JLabel labMostrarPlaca;
    private javax.swing.JLabel labMostrarPorta;
    private javax.swing.JLabel labMostrarTrava;
    private javax.swing.JLabel labMostrarVidro;
    private javax.swing.JTextField tfDevolver;
    private javax.swing.JTextField tfRetirada;
    // End of variables declaration//GEN-END:variables
}