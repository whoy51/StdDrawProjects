import java.awt.*;

public class GraphicsFun {
    public static void main(String[] args) {
        final int NUM_CIRCLES = 10000;
        int count = 0;
        StdDraw.enableDoubleBuffering();
        while (count < NUM_CIRCLES){
            double x = Math.random();
            double y = Math.random();
            double radius = Math.random() * .1 + 0.05;
            int alpha = 200;
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            Color color = new Color(r, g, b, alpha);
            StdDraw.setPenColor(color);
            StdDraw.filledCircle(x, y, radius);
            count++;
            System.out.println(count);

        }
        StdDraw.show();

    }
}
