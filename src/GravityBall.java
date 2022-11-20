public class GravityBall {
    public static void main(String[] args) {
        double xCtr = 0.5;
        double yCtr = 0.5;
        double rad = 0.03;
        double xVel = 0.001 + Math.random() * 0.001;
        double yVel = -0.001 + Math.random() * 0.001;
        final double G = -0.00005;

        StdDraw.setPenColor(StdDraw.randomColor(150));
        StdDraw.enableDoubleBuffering();
        while (true){
            StdDraw.clear();
            StdDraw.filledCircle(xCtr, yCtr, rad);
            StdDraw.show();
            yVel += G;

            // Move
            xCtr += xVel;
            yCtr += yVel;

            // Bounce
            if ((xCtr + rad >= 1) || (xCtr - rad <= 0)){
                xVel = -xVel;
            }
            if ((yCtr + rad >= 1) || (yCtr - rad <= 0)){
                yVel = -yVel;
            }
            StdDraw.pause(1000/60); // 60 fps
        }
    }
}
