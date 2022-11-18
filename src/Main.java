import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter # of points:");
        int points = scan.nextInt();
        int innerPoints = 0;
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i < points; i++){
            double x = Math.random();
            double y = Math.random();
            Color color = Color.BLACK;
            if ((x * x) + (y * y) > 1){
                System.out.println("outside of circle");
            }else {
                System.out.println("in circle");
                color = Color.MAGENTA;
                innerPoints++;
            }

            StdDraw.setPenColor(color);
            StdDraw.filledCircle(x, y, 0.001);

        }
        StdDraw.setPenColor(Color.RED);
        StdDraw.circle(0,0, 1);

        StdDraw.show();

        System.out.println((int)((double) innerPoints/ points * 100) + "%");
    }

}
