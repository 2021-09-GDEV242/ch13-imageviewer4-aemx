import java.awt.Color;

/**
 * Applies a green tint over the image.
 *
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public class GreenTintFilter extends Filter
{
    /**
     * GreenTintFilter's constructor method.
     * @param name The name of the filter.
     */
    public GreenTintFilter(String name)
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
                Color pixel = image.getPixel(x, y);
                int rb = (pixel.getRed() + pixel.getBlue()) / 2;
                image.setPixel(x, y, new Color(rb, 168, rb));
            }
        }
    }
}