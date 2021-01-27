package ru.vsu.cs.lazutkina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ButtonExecuteListener implements ActionListener
{
    private JSpinner sizeSpinner;
    private JSpinner levelSpinner;
    private JLabel labelImage;


    public ButtonExecuteListener(JSpinner sizeSpinner, JSpinner levelSpinner, JLabel labelImage)
    {
        this.sizeSpinner = sizeSpinner;
        this.levelSpinner = levelSpinner;
        this.labelImage = labelImage;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int size = (int) sizeSpinner.getValue();
        int level = (int) levelSpinner.getValue();

        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_BGR);
        Graphics2D g2d = image.createGraphics();
        
        g2d.setColor(Color.BLUE);
        PaintingFractal.paintFigure(g2d, image.getWidth(), image.getHeight(), level, new PaintingFractal.Painting()
        {
            @Override
            public void paint(Graphics2D g2d, int x, int y, int w, int h)
            {
                g2d.drawOval(x, y, w, h);
            }
        });
        labelImage.setIcon(new ImageIcon(image));
    }
}
