import java.awt.Color;

/**
 * Applies a rainbow effect over the image.
 *
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public class RainbowFilter extends Filter
{
    /**
     * RainbowFilter's constructor method.
     * @param name The name of the filter.
     */
    public RainbowFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * @param image The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //Color pixel = image.getPixel(x, y);
                //int red = pixel.getRed();
                // generate base rgb
                int red = (int) ((255/2) * Math.sin(2*Math.PI * (x+width/3)/width) + 255/2);
                int green = (int) ((255/2) * Math.sin(2*Math.PI * x/width) + 255/2);
                int blue = (int) ((255/2) * Math.sin(2*Math.PI * (x+2*width/3)/width) + 255/2);
                Color pixel = image.getPixel(x, y);
                int pxRed = pixel.getRed();
                int pxGreen = pixel.getGreen();
                int pxBlue = pixel.getBlue();
                int outRed = (int) (red+pxRed)/2;
                int outGreen = (int) (green+pxGreen)/2;
                int outBlue = (int) (blue+pxBlue)/2;
                image.setPixel(x, y, new Color(outRed, outGreen, outBlue));
            }
        }
    }
}