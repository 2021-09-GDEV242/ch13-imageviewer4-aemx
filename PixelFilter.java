import java.awt.Color;

/**
 * Applies a pixelation effect to the image.
 *
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public class PixelFilter extends Filter
{
    /**
     * PixelFilter's constructor method.
     * @param name The name of the filter.
     */
    public PixelFilter(String name)
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
        int square = 16;
        for (int dy = 1; dy <= square; dy++) {
            for (int dx = 1; dx <= square; dx++) {
                // set bounds
                int xStart = (dx-1)*(width/square);
                int yStart = (dy-1)*(height/square);
                int xEnd = dx*(width/square);
                int yEnd = dy*(height/square);
                // get pixel of top left corner
                Color pixel = image.getPixel(xStart, yStart);
                // repeat for xy section
                for (int y = yStart; y < yEnd; y++) {
                    for (int x = xStart; x < xEnd; x++) {
                        newImage.setPixel(x, y, pixel);
                    }
                }
            }
        }
    }
}