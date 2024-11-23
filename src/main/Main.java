package main;

import client.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * @author Kalud
 * @website pixelskider.github.io/
 * @since 2024/11/22
 */
public class Main extends JFrame {
    final int width = 168,height = 110;
    public Main(){
        this.setTitle("DesktopManager");
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setContentPane(new Panel(width,height));
    }
}