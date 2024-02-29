import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JFrame;
/**
 *
 * @author stefa
 */
public class ApartamentForm extends javax.swing.JFrame {
    static final String DB_URL = DatabaseHelper.DB_URL;
    static final String DB_USER = DatabaseHelper.DB_USER;
    static final String DB_PASS = DatabaseHelper.DB_PASS;
    int _selectedId = 0;
    private User user;
     private JFrame parent;
    /**
     * Creates new form ApartamentForm
     */
    public ApartamentForm() {
        initComponents();
        this.loadTable();
    }
    
    public ApartamentForm(User user, JFrame parent) {
        this.user = user;
        this.parent = parent;
        initComponents();
        this.loadTable();
        this.cboCondo.removeAllItems();
        populateCondoComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        cboCondo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFloor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBlock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableApartaments = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apartment Registration");

        jLabel1.setText("Number:");

        cboCondo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Condominium:");

        jLabel3.setText("Floor:");

        jLabel4.setText("Block:");

        tableApartaments.setModel(new javax.swing.table.DefaultTableModel(
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
        tableApartaments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableApartamentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableApartaments);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboCondo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBack))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String url =DB_URL;
        String user = DB_USER;
        String password = DB_PASS;

        // Dados a serem inseridos
        String number = txtNumber.getText();
        int floor = Integer.parseInt(txtFloor.getText());
        String block = txtBlock.getText();

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            //SQL to insert data
            String sql = "INSERT INTO Apartments (Number, CondoId, Floor, Block) VALUES (?, (SELECT ID FROM condominium WHERE Name = ?), ?, ?)";

           // Prepare and execute the SQL statement
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, number);
                preparedStatement.setString(2, this.cboCondo.getItemAt(cboCondo.getSelectedIndex()));
                preparedStatement.setInt(3, floor);
                preparedStatement.setString(4, block);

                // Executar a inserção
                int rowsAffected = preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Successfully inserted! " + rowsAffected + " affected line(s).");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
        loadTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableApartamentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableApartamentsMouseClicked
        // TODO add your handling code here:
         int selectedRow = tableApartaments.getSelectedRow();
        if (evt.getClickCount() == 1)
            _selectedId = (int) tableApartaments.getValueAt(selectedRow, 0);{
            DefaultTableModel model = (DefaultTableModel) tableApartaments.getModel();
            txtNumber.setText(model.getValueAt(selectedRow, 1).toString());
            txtFloor.setText(model.getValueAt(selectedRow, 2).toString());
            txtBlock.setText(model.getValueAt(selectedRow, 3).toString());
            // Adicionar o código para definir o valor em cboCondo com base no valor da tabela
        }
    }//GEN-LAST:event_tableApartamentsMouseClicked

    private void removeApartment(int apartmentId) {
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
        String sql = "DELETE FROM Apartments WHERE ApartmentId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, apartmentId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Apartment successfully removed!");
                loadTable();  
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove apartment");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

    private void populateCondoComboBox(){
    
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS))
        {
            String query = """
                        SELECT * FROM condominium C
                            INNER JOIN condohasadmin CA
                                ON C.ID = CA.IdCondoId
                        WHERE CA.IdAdminId = ?""";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, user.getID());
            ResultSet rs = stmt.executeQuery();
        
            

            while (rs.next()) {
                this.cboCondo.addItem(rs.getString("Name"));
            }
        }   
        catch (SQLException e) {
            // Handle the error. Maybe show a message to the user.
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableApartaments.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select an apartment to remove.");
            return;
        }

        int apartmentId = (int) tableApartaments.getValueAt(selectedRow, 0); // O ID deve estar na primeira coluna da tabela

        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove the selected apartment?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Chamar função para remover
            removeApartment(apartmentId);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        parent.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed
    private void loadTable(){
        try {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        String sql = """
                     select A.ApartmentId, C.Name, Number, Floor, Block  from Condominium C inner join Apartments A on A.CondoID = C.Id INNER JOIN condohasadmin CA
                             ON C.ID = CA.IdCondoId
                         WHERE CA.IdAdminId = ?""";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,user.getID());
        ResultSet rs = pstmt.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Number","Floor", "Block", "Condominium"}
        );
        this.tableApartaments.setModel(model);
       
        while(rs.next()) {
            Object[] row = new Object[6];
            row[0] = rs.getInt("ApartmentId");
            row[1] = rs.getString("Number");
            row[2] = rs.getString("Floor");
            row[3] = rs.getString("Block");
            row[4] = rs.getString("Name");
            model.addRow(row);
        }
        
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
            java.util.logging.Logger.getLogger(ApartamentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApartamentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApartamentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApartamentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApartamentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboCondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableApartaments;
    private javax.swing.JTextField txtBlock;
    private javax.swing.JTextField txtFloor;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
