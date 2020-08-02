package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Image2Black
{
    public static void main(String[] args)
    {
        BufferedImage image;
        int width;
        int height;

        try
        {
            File input = new File("image.jpg");  //also works with pngs

            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            for (int i = 0; i < height; i++)
            {
                for (int j = 0; j < width; j++)
                {              
                    Color c = new Color(image.getRGB(j, i));
                    int r = (int)(c.getRed() * 0.299);
                    int g = (int)(c.getGreen() * 0.587);
                    int b = (int)(c.getBlue() * 0.114);

                    int tot = r+g+b;
                    Color newColor = new Color(tot, tot, tot);
                    
                    image.setRGB(j, i, newColor.getRGB());
                }
            }
            File ouptut = new File("output.jpg");
            System.out.println("Finished");

            ImageIO.write(image, "jpg", ouptut);
        }
        catch (Exception ignored) {}
    }
}
