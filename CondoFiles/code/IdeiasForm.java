
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author stefa
 */
public class IdeiasForm extends javax.swing.JFrame {

    private static final String DB_URL = DatabaseHelper.DB_URL;
    private static final String DB_USER = DatabaseHelper.DB_USER;
    private static final String DB_PASS = DatabaseHelper.DB_PASS;
    private int _residentId = 0;
    private int _selectedId = 0;
    
    private JFrame parent;
    
    public IdeiasForm() {
        initComponents();
        _residentId = 1;
        this.loadIdeasIntoTable();
    }

    public IdeiasForm(int residentId, JFrame parent) {
        initComponents();
        _residentId = residentId;
        this.parent = parent;
        this.loadIdeasIntoTable();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableIdea = new javax.swing.JTable();
        StructuringCheck = new javax.swing.JCheckBox();
        txtBudget = new javax.swing.JTextField();
        User2 = new javax.swing.JLabel();
        checkIdea = new javax.swing.JCheckBox();
        checkSuggestion = new javax.swing.JCheckBox();
        User3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IDEAS REGISTRATION");

        tableIdea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableIdea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableIdeaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableIdea);

        StructuringCheck.setText("Structuring");

        txtBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBudgetActionPerformed(evt);
            }
        });

        User2.setText("Budget:");

        checkIdea.setSelected(true);
        checkIdea.setText("Idea");

        checkSuggestion.setText("Suggestion");

        User3.setText("Description:");

        jScrollPane2.setViewportView(txtDescription);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.setEnabled(false);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(User3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(461, 477, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkIdea, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkSuggestion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(User2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(StructuringCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StructuringCheck)
                    .addComponent(btnSave)
                    .addComponent(User2)
                    .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkIdea)
                    .addComponent(checkSuggestion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(User3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBudgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBudgetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       String typeOfRegister = "";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
        // Create the SQL query
        String query = "INSERT INTO Ideas (Description, IsStructural, Budget, ResidentID, Type) VALUES (?, ?, ?, ?, ?)";
        
        // Create a PreparedStatement
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Fill in the query parameters
            stmt.setString(1, txtDescription.getText()); // Description
            stmt.setBoolean(2, StructuringCheck.isSelected()); // IsStructural
            stmt.setFloat(3, Float.parseFloat(txtBudget.getText())); // Budget
            stmt.setInt(4, _residentId); // ResidentID
            
            // Check which checkbox is selected
            if (checkIdea.isSelected()) {
                stmt.setString(5, "Idea");
                typeOfRegister = "Idea";
            } else if (checkSuggestion.isSelected()) {
                stmt.setString(5, "Suggestion");
                typeOfRegister = "Suggestion";
            } else {
               JOptionPane.showMessageDialog(null, "Please, Select whether it is an idea or suggestion!");
                return;
            }
            
            // Execute the query
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success, registered idea");
            this.loadIdeasIntoTable();
        }
        
        // Close the connection
        conn.close();
        
    } catch (SQLException e) {
       JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    private void tableIdeaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableIdeaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            int selectedRow = tableIdea.getSelectedRow();

            // Carregando os valores em variáveis
            _selectedId = (int) tableIdea.getValueAt(selectedRow, 0);
            String description = (String) tableIdea.getValueAt(selectedRow, 1);
            float budget = (float) tableIdea.getValueAt(selectedRow, 3);
            this.txtDescription.setText(description);
            this.txtBudget.setText(String.valueOf(budget));
            btnRemove.setEnabled(true);
        }
    }//GEN-LAST:event_tableIdeaMouseClicked
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
       this.deleteIdea(_selectedId);
       this.loadIdeasIntoTable();
       this.txtBudget.setText("");
       this.txtDescription.setText("");
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.parent.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed
    public void deleteIdea(int ideaID) {
    
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        // Establish the database connection
        con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

        // Create SQL delete query
        String sql = "DELETE FROM Ideas WHERE ID = ?";

        // Create a PreparedStatement object to execute the query
        pstmt = con.prepareStatement(sql);

        // Set the parameter for the prepared statement (the idea ID)
        pstmt.setInt(1, ideaID);

        // Execute the delete operation
        int affectedRows = pstmt.executeUpdate();

        // Check if the delete was successful
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Successfully deleted the idea with ID: " + ideaID);
           
        } else {
            JOptionPane.showMessageDialog(null, "Could not find an idea with ID: " + ideaID);
            
            
        }
    } catch (SQLException e) {
        // Handle SQL exceptions
        JOptionPane.showMessageDialog(null, e.getMessage());
        
    } finally {
        // Close resources
        try {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            // Handle exceptions during resource release
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
    public void loadIdeasIntoTable() {
    try {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        String sql = "SELECT * FROM Ideas where ResidentID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, _residentId);
        ResultSet rs = pstmt.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Description", "IsStructural", "Budget", "ResidentID", "Type"}
        );
        tableIdea.setModel(model);
        // Preenchimento do DefaultTableModel
        while(rs.next()) {
            Object[] row = new Object[6];
            row[0] = rs.getInt("ID");
            row[1] = rs.getString("Description");
            row[2] = rs.getBoolean("IsStructural");
            row[3] = rs.getFloat("Budget");
            row[4] = rs.getInt("ResidentID");
            row[5] = rs.getString("Type");
            
            model.addRow(row);
        }
        
        // Fechamento de recursos
        rs.close();
        pstmt.close();
        conn.close();
       

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

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
            java.util.logging.Logger.getLogger(IdeiasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdeiasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdeiasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdeiasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IdeiasForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox StructuringCheck;
    private javax.swing.JLabel User2;
    private javax.swing.JLabel User3;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox checkIdea;
    private javax.swing.JCheckBox checkSuggestion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableIdea;
    private javax.swing.JTextField txtBudget;
    private javax.swing.JTextPane txtDescription;
    // End of variables declaration//GEN-END:variables
}
