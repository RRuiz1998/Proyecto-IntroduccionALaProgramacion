
package main;

import java.awt.Color;


public class Main {


    public static void main(String[] args) {

        
        Activities v = new Activities();
        v.setSize(720, 200);
        v.setResizable(false);
        v.setLocationRelativeTo(null);
        v.getContentPane().setBackground(Color.WHITE);
        
        v.setVisible(true);
    }

    
    
}
