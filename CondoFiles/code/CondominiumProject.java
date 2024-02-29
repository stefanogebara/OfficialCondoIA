/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author SAMSUNG
 */
public class CondominiumProject extends JFrame {
    
    public CondominiumProject() {
        
        setSize(400, 400);

        JLabel label0 = new JLabel();
        label0.setText("hello");
        add(label0);

        

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new CondominiumProject();
    }
}
