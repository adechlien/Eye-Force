package game;

import processing.core.PApplet;
import static processing.core.PConstants.HALF_PI;
import static processing.core.PConstants.PI;
import static processing.core.PConstants.QUARTER_PI;
import static processing.core.PConstants.TWO_PI;
import processing.core.PImage;

public class Radar extends PApplet {

    PImage icono;
    int count, add;
    float move;
    boolean on = false;

    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void setup() {
        icono = loadImage("/images/spidey.png");
        surface.setIcon(icono);
        count = 0;
    }

    @Override
    public void draw() {
        background(51, 51, 51);
        strokeWeight(1);
        // Color
        stroke(190, 231, 209);
//        stroke(250, 21, 29);

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
        // Lineas varias
        line(75, 250, 100, 250); // 1
        line(425, 250, 400, 250); // 2
        line(250, 75, 250, 100); // 3
        line(250, 425, 250, 400); // 4
        line(128, 128, 140, 140); // 1.1
        line(372, 128, 360, 140); // 2.1
        line(128, 372, 140, 360); // 3.1
        line(372, 372, 360, 360); // 4.1              

        strokeWeight(1);
        fill(190, 231, 209);
        textSize(20);
        text("Radar", 30, 480);

        strokeWeight(1);
        fill(240, 155, 140);
        rect(422, 450, 40, 30);
        fill(190, 231, 209);
        rect(380, 450, 40, 30);
        strokeWeight(3);
        if (on) {
            fill(0, 255, 0);
            line(380, 485, 420, 485);
        } else {
            fill(255, 0, 0);
            line(422, 485, 462, 485);
        }
        fill(0);
        textSize(14);
        text("On", 390, 470);
        text("Off", 430, 470);
        if ((mouseX > 380) && (mouseX < 420) && (mouseY > 450) && (mouseY < 480) && (mousePressed)) {
            on = true;
            add = 1;
        } else {
            if ((mouseX > 422) && (mouseX < 462) && (mouseY > 450) && (mouseY < 480) && (mousePressed)) {
                on = false;
                add = 0;
            }
        }
        // Aquí abajo dice qué hace
        lineasGiratorias(add);
    }

    public void run() {
        String[] processingArgs = {this.getClass().getName()};
        PApplet.runSketch(processingArgs, this);
    }

    void lineasGiratorias(int add) {
        delay(50);
        count = count + add;
        move = count * (2 * PI) / 60;
        translate(250, 250);
        rotate(move);
        strokeWeight(5);
        int alpha = 255, moveY[] = {-189, -190, -189, -189, -188, -187, -185, -184,
            -182, -180, -178, -176, -173, -170, -168, -165, -162, -159}, k = 0;
//        for (int i = 0; i > -70; i -= 5) {
//            stroke(240, 40, 40, alpha);
//            line(0, 0, i, moveY[k]);
//            alpha -= 15;
//            k++;
//        }
        stroke(240, 40, 40);
        line(0, 0, 0, -189);
    }

    void interruptor() {

    }

}
