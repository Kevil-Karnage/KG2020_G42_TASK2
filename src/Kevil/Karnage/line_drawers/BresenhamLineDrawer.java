package Kevil.Karnage.line_drawers;

import Kevil.Karnage.LineDrawer;

import javax.swing.plaf.metal.MetalTheme;
import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {

    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int m = 1;
        if (x1 > x2) {
            int c = x1; x1 = x2; x2 = c;
            c = y1; y1 = y2; y2 = c;
        }
        if (y1 > y2)
            m *= -1;

        int x = x1; int y = y1;
        int Dx = x2 - x1; int Dy = y2 - y1;
        int e = 2 * Dy * m - Dx;
        if (Math.abs(Dy) <= Math.abs(Dx)) {
            for (int i = 1; i <= Dx; i++) {
                pd.setPixel(x, y, Color.green);
                if (e >= 0) {
                    y += m;
                    e += -2 * Dx + 2 * Dy * m;
                } else
                    e += m * 2 * Dy;
                x++;
            }
        } else {
            for (int i = 1; i <= Math.abs(Dy); i++) {
                pd.setPixel(x, y, Color.magenta);
                if (e >= 0) {
                    x++;
                    e += -2 * Dy * m + 2 * Dx;
                } else
                    e += 2 * Dx;
                y += m;
            }
        }
    }
}

