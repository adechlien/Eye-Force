package game;

import processing.core.PApplet;
import processing.core.PImage;

public class Radar extends PApplet {

    @Override
    public void settings() {
        size(500, 500);
    }
    PImage icono;
    int circleX = 250, circleY = 50, count;
    float move;

    @Override
    public void setup() {
        background(51, 51, 51);
        icono = loadImage("/images/spidey.png");
        surface.setIcon(icono);
        count = 0;
    }

    @Override
    public void draw() {
        radar();
//         Arrow        
//        fill(240, 60, 60);
//        ellipse(circleX, circleY, 15, 15);
        // Movimiento de aguja                
        delay(80);
        count++;
        move = count * (2 * PI) / 60;
        translate(250, 250);
        rotate(move);
        strokeWeight(8);
        // Alpha .1
        stroke(70,50,50);
        line(0, 0, -63, -189);
        // Alpha .2
        stroke(89,49,49);
        line(0, 0, -56, -190);
        // Alpha .3
        stroke(108,48,48);
        line(0, 0, -49, -191);
        // Alpha .4
        stroke(127,47,47);
        line(0, 0, -42, -192);
        // Alpha .5
        stroke(146,46,46);
        line(0, 0, -35, -194);
        // Alpha .6
        stroke(164, 44, 44);
        line(0, 0, -28, -194);
        // Alpha .7
        stroke(183, 43, 43);
        line(0, 0, -21, -194);
        // Alpha .8
        stroke(202, 42, 42);
        line(0, 0, -14, -194);
        // Alpha .9
        stroke(221, 41, 41);
        line(0, 0, -7, -193);
        // Alpha 1
        stroke(240, 40, 40);
        line(0, 0, 0, -192);
    }

    public void run() {
        String[] processingArgs = {this.getClass().getName()};
        PApplet.runSketch(processingArgs, this);
    }

    void radar() {
        background(51, 51, 51);
        strokeWeight(1);
        // Color
//        stroke(190, 231, 209);
        stroke(240, 40, 40);
        // Y-Axis and X-Axis
        line(250, 40, 250, 460);
        line(40, 250, 460, 250);

        // Diagonales varias
        line(174, 174, 186, 186);
        line(326, 174, 314, 186);
        line(174, 326, 186, 314);
        line(326, 326, 314, 314);

        // Circles
        noFill();
        arc(250, 250, 370, 370, 0, QUARTER_PI);
        arc(250, 250, 370, 370, HALF_PI, PI - QUARTER_PI);
        arc(250, 250, 370, 370, PI, PI + QUARTER_PI);
        arc(250, 250, 370, 370, PI + HALF_PI, TWO_PI - QUARTER_PI);
        for (int i = 50; i <= 275; i += 75) {
            ellipse(250, 250, i, i);
        }
        // Lineas gruesas
        strokeWeight(4);
        // Circulo mas grande
        ellipse(250, 250, 350, 350);
        // Cruz central
        line(240, 250, 260, 250);
        line(250, 240, 250, 260);
        // 
        line(75, 250, 100, 250);
        line(425, 250, 400, 250);
        line(250, 75, 250, 100);
        line(250, 425, 250, 400);

        line(128, 128, 140, 140); // 1
        line(372, 128, 360, 140); // 2
        line(128, 372, 140, 360); // 3
        line(372, 372, 360, 360); // 4                

        strokeWeight(1);
        fill(190, 231, 209);
        textSize(20);
        text("Radar", 10, 490);
    }

}
