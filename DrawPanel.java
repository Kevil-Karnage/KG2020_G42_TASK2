package Kevil.Karnage;

import Kevil.Karnage.line_drawers.BresenhamLineDrawer;
import Kevil.Karnage.line_drawers.DDALineDrawer;
import Kevil.Karnage.line_drawers.PixelDrawer;
import Kevil.Karnage.line_drawers.WuLineDrawer;
import Kevil.Karnage.pixel_drawers.GraphicsPixelDrawer;
import Kevil.Karnage.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        bi_g.setColor(Color.white);
        bi_g.fillRect(0,0,getWidth(), getHeight());
        bi_g.setColor(Color.black);
        bi_g.setColor(Color.orange);

        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);

        LineDrawer dld = new DDALineDrawer(pd);
        LineDrawer bld = new BresenhamLineDrawer(pd);
        LineDrawer wld = new WuLineDrawer(pd);
        DrawUtils.drawSnowflake(dld, 100, 100, 75, 50);
        dld.drawLine(100, 100, position.x, position.y);
        DrawUtils.drawSnowflake(bld, 300, 100, 75, 50);
        bld.drawLine(300, 100, position.x, position.y);
        DrawUtils.drawSnowflake(wld, 500, 100, 75, 50);
        wld.drawLine(500, 100, position.x, position.y);
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose(); //убираемся
    }

    private void drawAll(LineDrawer ld) {
        DrawUtils.drawSnowflake(ld, getWidth() / 2, getHeight() / 2, 100, 50);
        ld.drawLine(getWidth() / 2, getHeight() / 2, position.x, position.y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();

    }
}



