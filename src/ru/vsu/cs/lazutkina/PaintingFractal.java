package ru.vsu.cs.lazutkina;

import java.awt.*;

public class PaintingFractal
{

    public interface Painting
    {
        void paint(Graphics2D g2d, int x, int y, int w, int h);
    }

    private static void paintFigureLevel(Graphics2D g2d, double x, double y, double sideCanvas, int level, Painting painting)
    {
        double diameter = sideCanvas / 5;
        if (level > 0)
        {
            painting.paint(g2d, (int) (x + diameter * 2), (int) (y + diameter * 2), (int) diameter, (int) diameter);
            paintFigureLevel(g2d, x, y + diameter * 1.5, diameter * 2, level - 1, painting);
            paintFigureLevel(g2d, x + diameter * 1.5, y, diameter * 2, level - 1, painting);
            paintFigureLevel(g2d, x + diameter * 3, y + diameter * 1.5, diameter * 2, level - 1, painting);
            paintFigureLevel(g2d, x + diameter * 1.5, y + diameter * 3, diameter * 2, level - 1, painting);
        }
    }

    public static void paintFigure(Graphics2D g2d, int width, int height, int levelCount, Painting painting)
    {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        paintFigureLevel(g2d, 0, 0, width, levelCount, painting);
    }
}
