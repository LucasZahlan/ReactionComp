//this game is based on reaction times. 

import processing.core.PApplet;

import java.util.Random;

import processing.core.PFont;


public class ReactionComp extends PApplet {
//declerations
    public int startTime;
    public int timer;
    int number;
    int stoptime;
    int score;
    PFont font;
    boolean fail = false;
    boolean starts = false;

    Random randomnumbers1 = new Random();

    //White screen then array
    public static void main(String[] args) {
        PApplet.main("ReactionComp");
        String[] fontList = PFont.list();

    }
// canvas size
    public void settings() {

        size(800, 600);

    }
//starts a timer..
    public void startTimer() {
        startTime = millis();
        System.out.println(startTime);

    }

    public void setup() {
//setup for the draw
        System.out.println();
        background(255, 255, 255);
        textFont(createFont("Arial", 17, true));
    }
//draws on screen
    public void draw() {
//text for screen with coordinates
        background(255, 255, 255);
        fill(5, 5, 5);
        text("When the green circle pops up, click the mouse", 20, 40);
        text("After pressing start, move the cursor away from both buttons,", 5, 12);
        text("be sure to spam the top of the window for a second or two to ensure that you are tabbed into the game, ", 10, 70);
        text(" The circle will appear randomly within 10 seconds (minimum of 2), and will appear in the red box.", 10, 540);
        text("keep the cursor still after you move away from the start button!", 10, 90);
        text("Good Luck! If you missed it or didn't know what to do, simply restart.", 288, 400);
//circle is in here
        fill(255, 0, 0);
        rect(440, 120, 200, 40);
        rect(24, 150, 250, 250);
        fill(0, 220, 30);
        rect(440, 200, 200, 40);
      //  System.out.println(timer);
//calculates time
        if (starts) {
            timer = millis() - startTime;
            text("started", 485, 275);
            //  System.out.println("timer = millis () - starttime,,,, at " + starts);
        }
        fill(0, 0, 0);
        text("Press here to reset", 465, 145);
        text("Press here to start", 465, 225);

        //System.out.println(timer);
        if (fail) {
            text("    Score invalid, you clicked too soon :( .", 350, 350);
                    }
//shapes
        if (timer > number) {
            //System.out.println("done");
            fill(0, 255, 0);
            ellipse(244, 250, 30, 30);
            ellipse(147, 273, 250, 250);
            fill(255, 255, 255);
            rect(150, 424, 195, 24);
            fill(250, 5, 5);
            if (score < 315 && score > 0) {
                fill(0, 250, 10);
                                         }

                            }
        if (score > 0){
            text("Your time is  " + score + "  Ms!", 155, 440);
                       }
        fill(250,5,5);
        text("If a time is in black text, play normally and it will change." ,1,570);
        text("Creator record: 238", 600, 490);
        text("Created by: Lucas Zahlan", 600, 515);
    }

//mouseclick statements

    @Override
    public void mousePressed() {
        stoptime = millis();
        score = stoptime - number - startTime;
        System.out.println("Your time is " + score);
        if (score < 0 && starts) {
            fail = true;
            System.out.println("You clicked too fast, score invalid.");
        }
        if (440 < mouseX && mouseX< 640 && 120 <mouseY && mouseY< 160) {
            System.out.println("reset button");
            timer = 0;
            starts = false;
            number = 2000 + randomnumbers1.nextInt(8000);

        }

            //picks a new number to restart
        if (440<mouseX && mouseX<640 && 200<mouseY && mouseY<240) {
               starts = true;
               startTimer();
            number = 2000 + randomnumbers1.nextInt(9000);
                System.out.println("start");
if (starts == true){ fail = false; }
            }
    }
}