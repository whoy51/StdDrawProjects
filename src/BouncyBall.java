import java.awt.Color;

public class BouncyBall {
    static boolean holdInProgress = false;
    static boolean mouseState = false;
    static double ballX = 0.5;
    static double ballY = 0.5;
    static double ballVX = 0;
    static double ballVY = 0;
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(400, 400);
        StdDraw.setPenColor(Color.RED);

        while (true){
            if (mouseState && !StdDraw.isMousePressed()) {
                onMouseReleased();
                mouseState = false;
            }
            else if (!mouseState && StdDraw.isMousePressed()){
                onMouseClick();
                mouseState = true;
            }
            else if (mouseState && !holdInProgress){
                onMouseHold();
            }


            if (ballX > 1 || ballX < 0) ballVX *= -1;
            if (ballY > 1 || ballY < 0) ballVY *= -1;
            ballX += ballVX;
            ballY += ballVY;
            StdDraw.clear();
            StdDraw.filledCircle(ballX, ballY, 0.05);
            StdDraw.pause(20);
            StdDraw.show();


        }
    }
    public static void onMouseClick(){
        ballX = StdDraw.mouseX();
        ballY = StdDraw.mouseY();
        ballVY = 0;
        ballVX = 0;
    }
    public static void onMouseReleased(){
        ballVX = (ballX - StdDraw.mouseX())/10;
        ballVY = (ballY - StdDraw.mouseY())/10;
    }
    public static void onMouseHold(){
        holdInProgress = true;
        StdDraw.line(ballX, ballY, StdDraw.mouseX(), StdDraw.mouseY());
        StdDraw.show();
        StdDraw.clear();
        StdDraw.filledCircle(ballX, ballY, 0.05);
        StdDraw.line(ballX, ballY, StdDraw.mouseX(), StdDraw.mouseY());
        StdDraw.pause(20);
        StdDraw.show();
        holdInProgress = false;

    }

}