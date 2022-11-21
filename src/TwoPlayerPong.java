import java.awt.*;

public class TwoPlayerPong {
    public static void main(String[] args) {

        // Initial values
        double ballX = 0.5;
        double ballY = 0.5;
        double ballVX = 0.02;
        double ballVY = 0;

        // paddle values
        double paddle1VY = 0;
        double paddle1Y = 0.5;
        double paddle2VY = 0;
        double paddle2Y = 0.5;

        StdDraw.enableDoubleBuffering();
        StdDraw.setTitle("Multiplayer Pong");

        StdDraw.setCanvasSize(400, 400);


        while (true){
            // Paddle 1: Both W and S pressed
            if (StdDraw.isKeyPressed(87) && StdDraw.isKeyPressed(83)) {
                paddle1VY = 0;
            }else if (StdDraw.isKeyPressed(87)) {
                paddle1VY = 0.025;
            }else if (StdDraw.isKeyPressed(83)) {
                paddle1VY = -0.025;
            }else {
                paddle1VY = 0;
            }
            // Paddle 2: up and down keys
            if (StdDraw.isKeyPressed(38) && StdDraw.isKeyPressed(40)) {
                paddle2VY = 0;
            }else if (StdDraw.isKeyPressed(38)) {
                paddle2VY = 0.025;
            }else if (StdDraw.isKeyPressed(40)) {
                paddle2VY = -0.025;
            }else {
                paddle2VY = 0;
            }

            // If hit edge, bounce
            if (ballX > 1 || ballX < 0) ballVX *= -1;
            if (ballY > 1 || ballY < 0) ballVY *= -1;
            // If hit left or right edge, die
            if (ballX < 0 || ballX > 1) {
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
            if (ballX > 0.1 && ballX < 0.15 && Math.abs(ballY - paddle1Y) < 0.1) {
                ballVX = 0.02;
                ballVY = (Math.random() - 0.5)/25;
            }
            if (ballX > 0.85 && ballX < 0.9 && Math.abs(ballY - paddle2Y) < 0.1) {
                ballVX = -0.02;
                ballVY = (Math.random() - 0.5)/25;
            }
            // Move
            ballX += ballVX;
            ballY += ballVY;

            paddle1Y += paddle1VY;
            paddle2Y += paddle2VY;

            // Render objects
            StdDraw.clear();
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledCircle(ballX, ballY, 0.03);
            StdDraw.setPenColor(Color.MAGENTA);

            // render rectangles
            StdDraw.filledRectangle(0.1, paddle1Y, 0.02, 0.1);
            StdDraw.filledRectangle(0.9, paddle2Y, 0.02, 0.1);
            StdDraw.pause(20);
            StdDraw.show();


        }
    }
}
