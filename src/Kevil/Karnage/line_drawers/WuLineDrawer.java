package Kevil.Karnage.line_drawers;

import Kevil.Karnage.LineDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    public void draw(int x1, int y1, int x2, int y2, boolean change) {
        Color baseColor = Color.black;
        int red = baseColor.getRed();
        int green = baseColor.getGreen();
        int blue = baseColor.getBlue();
        int step = 1;
        pd.setPixel(x1, y1, baseColor);
        if (x1 > x2) {
            int c = x1;
            x1 = x2;
            x2 = c;
            c = y1;
            y1 = y2;
            y2 = c;
        }
        if (y1 > y2)
            step *= -1;

        int dx = x2 - x1;
        int dy = step * (y2 - y1);
        int x = x1 + 1;
        int y = y1;
        int yy = y1;
        double tg = (double) dy / dx;
        double y_line;
        double grad;

        int e = 2 * dy - dx;
        int e1 = 2 * dy;
        int d2 = 2 * (dy - dx);
        while (x < x2) {
            y_line = tg * (x - x1) * step + y1;
            if (e < 0) {
                e = e + e1;
            } else if (e >= 0) {
                e = e + d2;
                y = y + step;
            }
            if (((step > 0) && (y_line > y)) || ((step < 0) && (y_line < y))) {
                yy = y + step;
            } else {
                yy = y - step;
            }
            if (yy == y) {
                grad = 1;
            } else {
                if (Math.abs(y_line - y) < 1) {
                    grad = Math.abs((y_line - y));
                } else grad = Math.abs(y_line - yy);
            }
            Color color;
            if (change) {

                color = new Color(red, green, blue, (int) (255 * grad));
                pd.setPixel(yy, x, color);
                color = new Color(red, green, blue, (int) (255 * (1 - grad)));
                pd.setPixel(y, x, color);

            } else {
                color = new Color(red, green, blue, (int) (255 * grad));
                pd.setPixel(x, yy, color);
                color = new Color(red, green, blue, (int) (255 * (1 - grad)));
                pd.setPixel(x, y, color);
            }
            x++;
        }
    }

    @Override
        public void drawLine(int x1, int y1, int x2, int y2) {
        int dy = y2 - y1;
        int dx = x2 - x1;
        if (Math.abs(dy) < Math.abs(dx)) {
            draw(x1, y1, x2, y2, false);
        } else if (Math.abs(dy) >= Math.abs(dx)) {
            draw(y1, x1, y2, x2, true);
        }
    }
}
