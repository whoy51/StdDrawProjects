import java.awt.*;

public class PongGame {
    public static void main(String[] args) {

        // Initial values
        double ballX = 0.5;
        double ballY = 0.5;
        double ballVX = 0.02;
        double ballVY = 0.02;

        StdDraw.enableDoubleBuffering();
        StdDraw.setTitle("Singleplayer Pong");

        StdDraw.setCanvasSize(400, 400);


        while (true){
            // If hit edge, bounce
            if (ballX > 1 || ballX < 0) ballVX *= -1;
            if (ballY > 1 || ballY < 0) ballVY *= -1;
            // If hit left edge, die
            if (ballX < 0) {
                StdDraw.clear();
                StdDraw.setPenColor(Color.RED);
                StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(0.5, 0.55, "You died!");
                StdDraw.text(0.5, 0.45, "To play again, run the program.");
                StdDraw.pause(20);
                StdDraw.show();
                break;
            }
            // If hit paddle, bounce
            if (ballX > 0.1 && ballX < 0.15 && Math.abs(ballY - StdDraw.mouseY()) < 0.1) {
                ballVX = 0.02;
            }
            // Move
            ballX += ballVX;
            ballY += ballVY;

            // Render objects
            StdDraw.clear();
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledCircle(ballX, ballY, 0.03);
            StdDraw.setPenColor(Color.MAGENTA);
            StdDraw.filledRectangle(0.1, StdDraw.mouseY(), 0.02, 0.1);
            StdDraw.pause(20);
            StdDraw.show();


        }
    }
}
