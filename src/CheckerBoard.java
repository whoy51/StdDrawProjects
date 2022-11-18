import java.awt.*;

public class CheckerBoard {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(250, 250);
        for (double i = 1; i <= 8; i++){
            for (double k = 1; k <= 8; k++){
                if ((i + k) % 2 == 0){
                    StdDraw.setPenColor(Color.BLACK);
                }
                else {
                    StdDraw.setPenColor(Color.WHITE);
                }
                StdDraw.filledSquare(k/10 + .05, i/10 + 0.05, 0.05);
            }
        }
        StdDraw.square(0.5, 0.5, 0.4);
    }

}
