package ru.vsu.cs.lazutkina;

import java.awt.*;
import java.awt.geom.Path2D;

public class DrawingTriangle
{
    private static void paintTriangleLevel(Graphics2D g2d, double x, double y, double width, double height, int level) {
        if (level > 0)
        {
            paintTriangleLevel(g2d, x + width / 4, y, width / 2, height / 2, level - 1);
            paintTriangleLevel(g2d, x, y + height / 2, width / 2, height / 2, level - 1);
            paintTriangleLevel(g2d, x + width / 2, y + height / 2, width / 2, height / 2, level - 1);
        }
        else
        {
            Path2D.Double path = new Path2D.Double();
            path.moveTo(x + width / 2, y);
            path.lineTo(x + width, y + height);
            path.lineTo(x, y + height);
            path.closePath();
            g2d.fill(path);
        }
    }

    public static void paintTriangle(Graphics2D g2d, int width, int height, int levelCount) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = g2d.getColor();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(color);
        paintTriangleLevel(g2d, 0, 0, width, height, levelCount - 1);
    }
}
