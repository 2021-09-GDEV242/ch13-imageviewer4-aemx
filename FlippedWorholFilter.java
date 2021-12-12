import java.awt.Color;

/**
 * Applies a filter to the image in the style
 * of Andy Worhol's pop art.
 *
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public class FlippedWorholFilter extends Filter
{
    /**
     * FlippedWorholFilter's constructor method.
     * @param name The name of the filter.
     */
    public FlippedWorholFilter(String name)
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
        OFImage newImage = image;
        for (int y = 0; y < height/2; y++) {
            for (int x = 0; x < width/2; x++) {
                // 1 Original image
                newImage.setPixel(x, y, image.getPixel(x*2, y*2)); //only need to resize for the first one
            }
        }
        for (int y = 0; y < height/2; y++) {
            for (int x = 0; x < width/2; x++) {
                Color pixel = newImage.getPixel(x, y);
                int red = pixel.getBlue();
                int green = pixel.getBlue();
                int blue = pixel.getBlue();
                // 2 Red tint
                newImage.setPixel(width-1-x, y, new Color(red, 0, 0));
                // 3 Green tint
                newImage.setPixel(x, height-1-y, new Color(0, green, 0));
                // 4 Blue tint
                newImage.setPixel(width-1-x, height-1-y, new Color(0, 0, blue));
            }
        }
    }
}