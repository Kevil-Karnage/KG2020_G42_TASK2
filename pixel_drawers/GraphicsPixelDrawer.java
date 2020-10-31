package Kevil.Karnage.pixel_drawers;

import Kevil.Karnage.line_drawers.PixelDrawer;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer {
    private Graphics gr;

    public GraphicsPixelDrawer(Graphics gr) {
        this.gr = gr;
    }

    @Override
    public void setPixel(int x, int y, Color c) {
        gr.setColor(c);
        gr.drawLine(x, y, x, y);
    }
}
