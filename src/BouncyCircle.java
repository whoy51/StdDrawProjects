import java.awt.Color;

public class BouncyCircle {
    public static void main(String[] args) {
        double xCtr = 0.5;
        double yCtr = 0.5;
        double rad = 0.03;
        double xVel = 0.001;
        double yVel = -0.001;

        StdDraw.setPenColor(Color.MAGENTA);
        StdDraw.enableDoubleBuffering();
        while (true){
            StdDraw.clear();
            StdDraw.filledCircle(xCtr, yCtr, rad);
            StdDraw.show();
            xCtr += xVel;
            yCtr += yVel;
        }
    }
}
