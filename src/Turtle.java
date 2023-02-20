import java.awt.*;

/**
 * A robot turtle that can draw to the screen.
 *
 * @author AP CSA (Dec 2022)
 */
public class Turtle {
    // Static fields
    private static int population = 0;

    public static final double UP = 90, DOWN = 270, LEFT = 180, RIGHT = 0;


    // Instance Fields
    private double xCtr = 0.5, yCtr = 0.5; // middle of screen

    /**
     * Direction in degrees in standard position
     * 0 is right, 90 is up, etc.
     * Value between [0 and 360).
     */
    private double dir = UP; // up

    /** Color of turtle's pen. */
    private Color color = Color.GREEN;
    /** Should turtle draw line while moving? */
    private boolean isPenDown = true;

    /** Window to draw to. */
    private final Draw win;


    // Constructors
    public Turtle(Draw win){
        population++;
        System.out.println("Turtle born! New pop: " + population);
        this.win = win;
    }

    public void setPenDown(boolean isPenDown){
        this.isPenDown = isPenDown;
    }

    /**
     * Turns the turtle given number of degrees
     * counterclockwise
     */
    public void turn(double dir){
        this.dir += dir;
        this.dir %= 360;
        if (this.dir < 0 ) {this.dir += 360;}
        System.out.println("New dir: " + this.dir);
    }

    /**
     * Move turtle forward given distance, drawing
     * line if pen is down.
     */
    public void crawl(double dist) {
        double oldXCtr = xCtr;
        double oldYCtr = yCtr;
        double rads = Math.toRadians(dir);
        double dx = dist * Math.cos(rads);
        double dy = dist * Math.sin(rads);
        xCtr += dx;
        yCtr += dy;
        if (isPenDown) {
            win.setPenColor(color);
            win.line(oldXCtr, oldYCtr, xCtr, yCtr);
        }
    }

    public static void main(String[] args) {
        Draw window = new Draw();
        window.setTitle("I like Turtles!");
        Turtle bob = new Turtle(window);
        for (int i = 0; i < 720; i++){
            bob.crawl(0.001);
            bob.turn( 0.5);
        }
        Turtle alice = new Turtle(window);
        for (int i = 0; i < 720; i++){
            alice.crawl(0.01);
            alice.turn(Math.random() * 20 - 10);
        }
    }

}
