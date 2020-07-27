package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class image2Black
{
    public static void main(String[] args)
    {
        BufferedImage image;
        int width;
        int height;

        try
        {
            File input = new File("C:\\Users\\Yug\\Desktop\\nature.jpg");

            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            for (int i = 0; i < height; i++)
            {
                for (int j = 0; j < width; j++)
                {
                    Color c = new Color(image.getRGB(j, i));
                    int red = (int)(c.getRed() * 0.299);
                    int green = (int)(c.getGreen() * 0.587);
                    int blue = (int)(c.getBlue() *0.114);
                    Color newColor = new Color(red+green+blue,
                            red+green+blue,red+green+blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("C:\\Users\\Yug\\Desktop\\natureBlack.jpg");
            System.out.println("Finished");

            ImageIO.write(image, "jpg", ouptut);
        }
        catch (Exception ignored) {}
    }
}