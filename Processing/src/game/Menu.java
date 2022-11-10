package game;

import processing.core.PApplet;
import processing.core.PImage;

public class Menu extends PApplet {

    PImage icono;
    int circleX = 250, circleY = 50, count = 0;
    float move;
    
    @Override
    public void settings() {
        size(480, 560);
    }    

    @Override
    public void setup() {
        icono = loadImage("/images/spidey.png");
        surface.setIcon(icono);
    }

    @Override
    public void draw() {
        menu();

    }

    public void run() {
        String[] processingArgs = {this.getClass().getName()};
        PApplet.runSketch(processingArgs, this);
    }

    boolean boton = false;

    void menu() {
        background(204, 227, 222);

        fill(164, 195, 178);
        ellipse(240, 180, 150, 150);

        fill(60, 110, 113);
        textSize(24);
        text("Nombre", 210, 30, 100, 40);
        textSize(18);

        rect(-1, 320, 120, 40);
        rect(-1, 380, 120, 40);
        rect(-1, 440, 120, 40);
        fill(255);
        textSize(20);
        text("Opcion 1", 15, 325, 100, 40);
        text("Opcion 3", 15, 385, 100, 40);
        text("Opcion 5", 15, 445, 100, 40);
        
        rect(360, 320, 120, 40);

        if ((mouseX > -1) && (mouseX < 119) && (mouseY > 320) && (mouseY < 360) && (mousePressed)) {
            fill(91, 139, 142);
            boton = true;
        }
        
        if (boton) {
            
        }
    }

}
