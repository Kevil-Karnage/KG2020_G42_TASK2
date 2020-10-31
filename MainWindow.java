package Kevil.Karnage;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{

    private DrawPanel dp;

    public MainWindow() throws HeadlessException {
        dp = new DrawPanel();
        this.add(dp);
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mw.setSize(1280,720);
        mw.setVisible(true);}
}
