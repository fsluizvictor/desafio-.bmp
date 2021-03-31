package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

public class CountPixels extends java.awt.Color {
    public CountPixels(int rgb) {
        super(rgb);
        // TODO Auto-generated constructor stub
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) throws IOException {

        ArrayList colors_count = new ArrayList<>();
        Set colors = new HashSet<>();
        File file = new File("/home/luiz_victor/Projects/image_synge/src/controllers/Syngenta.bmp");
        BufferedImage image = null;

        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int height = image.getHeight();
        int width = image.getWidth();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                colors.add(image.getRGB(x, y));
                colors_count.add(image.getRGB(x, y));
            }
        }

        int cont1 = 0, cont2 = 0, cont3 = 0;

        for (Object object : colors_count) {
            if (object.equals(-16777216)) {
                cont1++;
            } else if (object.equals(-10436608)) {
                cont2++;
            }
            if (object.equals(-1)) {
                cont3++;
            }
        }

        System.out.println(cont1);
        System.out.println(cont2);
        System.out.println(cont3);
        for (Object object : colors) {
            System.out.println(object);
            int rgb = (int) object;
            CountPixels c = new CountPixels(rgb);
            int alpha = c.getAlpha();
            int red = c.getRed();
            int green = c.getGreen();
            int blue = c.getBlue();
            System.out.println(red + "," + green + "," + blue);

        }
    }
}
