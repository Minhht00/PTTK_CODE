/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package huce.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ListRequestsPanel extends javax.swing.JPanel {

    /**
     * Creates new form ListRequestsPanel
     */
    public ListRequestsPanel() {
        initComponents();
        var tableModel = (DefaultTableModel) jListRequestsTable.getModel();
        this.jListRequestsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int row = jListRequestsTable.getSelectedRow();
                String state = (String) tableModel.getValueAt(row, 4);
                if (state.equals("Chờ xử lý")) {
                    jAcceptBtn.setEnabled(true);
                    jRefuseBtn.setEnabled(true);
                } else {
                    jAcceptBtn.setEnabled(false);
                    jRefuseBtn.setEnabled(false);
                }
            }

        });
        this.jListRequestsTable.getModel().addTableModelListener((e) -> {
            if (e.getType() == TableModelEvent.INSERT) {
                var data = tableModel.getDataVector();
                data.sort( (a, b) -> {
                    if ( ((String) a.elementAt(4)).equals("Chờ xử lý") ) {
                        return -1;
                    }
                    return 1;
                } );
            }
        });
        this.jAcceptBtn.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "Ok");
            int row = jListRequestsTable.getSelectedRow();
            tableModel.setValueAt("Đã duyệt", row, 4);
            jAcceptBtn.setEnabled(false);
            jRefuseBtn.setEnabled(false);
        });
        this.jRefuseBtn.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "Ok");
            int row = jListRequestsTable.getSelectedRow();
            tableModel.setValueAt("Từ chối", row, 4);
            jAcceptBtn.setEnabled(false);
            jRefuseBtn.setEnabled(false);
        });
        this.jViewNewestRequestsBtn.addActionListener((e) -> {
            tableModel.addRow(new String[]{"12", "243", "23434", "2323", "Chờ xử lý"});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jListRequestsTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jAcceptBtn = new javax.swing.JButton();
        jRefuseBtn = new javax.swing.JButton();
        jViewNewestRequestsBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jListRequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "1234", "04-Mart1", "Hoàng Mai", "Chờ xử lý"},
                {"3", "23", "abcdg", "fdgdf", "Từ chối"},
                {"4", "2343", "gffg", "degfr", "Đã Duyệt"},
                {"2", "456", "04-Mart2", "Linh Nam", "Chờ xử lý"}
            },
            new String [] {
                "ID phiếu", "ID cửa hàng", "Tên cửa hàng", "Địa chỉ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jListRequestsTable.setShowGrid(false);
        jScrollPane1.setViewportView(jListRequestsTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jAcceptBtn.setText("Duyệt");
        jAcceptBtn.setEnabled(false);
        jPanel1.add(jAcceptBtn);

        jRefuseBtn.setText("Từ chối");
        jRefuseBtn.setEnabled(false);
        jPanel1.add(jRefuseBtn);

        jViewNewestRequestsBtn.setText("Xem các yêu cầu mới");
        jPanel1.add(jViewNewestRequestsBtn);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách các yêu cầu");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAcceptBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jListRequestsTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jRefuseBtn;
    private javax.swing.JButton jViewNewestRequestsBtn;
    // End of variables declaration//GEN-END:variables
}
