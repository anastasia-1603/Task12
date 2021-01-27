package ru.vsu.cs.lazutkina;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame
{
    private JPanel panel;
    private JLabel labelImage;
    private JSpinner sizeSpinner;
    private JSpinner levelSpinner;
    private JButton buttonDraw;
    private JLabel sizeTextLabel;
    private JLabel levelTextLabel;

    public Frame()
    {
        super("Draw circle fractal");
        panel = new JPanel();
        labelImage = new JLabel();
        sizeTextLabel = new JLabel("Figure size:");
        levelTextLabel = new JLabel("Number of recursion levels");

        SpinnerNumberModel sizeSpinnerModel = new SpinnerNumberModel(300, 0, 1000, 10);
        sizeSpinner = new JSpinner(sizeSpinnerModel);

        SpinnerNumberModel levelSpinnerModel = new SpinnerNumberModel(5, 0, 25, 1);
        levelSpinner = new JSpinner(levelSpinnerModel);

        buttonDraw = new JButton("Draw");

        addActionToButton();
        addComponentsToPanels();
        initImage();
        initFrame(panel);
    }

    private void addActionToButton()
    {
        buttonDraw.addActionListener(new ButtonExecuteListener(sizeSpinner, levelSpinner, labelImage));
    }

    private void initImage()
    {
        int size = (int) sizeSpinner.getValue();

        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_BGR);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, size, size);
        labelImage.setIcon(new ImageIcon(image));
    }

    private void addComponentsToPanels()
    {
        panel.add(levelTextLabel);
        panel.add(levelSpinner);
        panel.add(sizeTextLabel);
        panel.add(sizeSpinner);
        panel.add(buttonDraw);
        panel.add(labelImage);
    }

    private void initFrame(JPanel panel)
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
        this.pack();
    }
}
