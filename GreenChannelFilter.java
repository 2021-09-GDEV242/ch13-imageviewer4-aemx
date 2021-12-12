import java.awt.Color;

/**
 * Isolates the green in an image and creates a grayscale
 * map of it. Higher values are white, lower values are black.
 *
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public class GreenChannelFilter extends Filter
{
    /**
     * GreenChannelFilter's constructor method.
     * @param name The name of the filter.
     */
    public GreenChannelFilter(String name)
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
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) 
            {
                Color pixel = image.getPixel(x, y);
                int green = pixel.getGreen();
                image.setPixel(x, y, new Color(green, green, green));
            }
        }
    }
}