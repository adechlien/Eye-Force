package game;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Menu extends PApplet {

    PImage icono, icono2;
    PFont font;

    int count = 0, x = 0, y = 10, moveX = 10, moveY = 10;
    float move;
    boolean botonSalir;

    @Override
    public void settings() {
        size(640, 480);
    }

    @Override
    public void setup() {
        icono = loadImage("images/icon.png");
        icono2 = loadImage("images/icon.png");
        surface.setIcon(icono);
        font = createFont("Candara-BoldItalic-20.vlw", 18);
        textFont(font);
    }

    @Override
    public void draw() {
        menu();
//        animacion();
//        String[] fontList = PFont.list();
//        printArray(fontList);
    }

    public void run() {
        String[] processingArgs = {this.getClass().getName()};
        PApplet.runSketch(processingArgs, this);
    }

    boolean boton = false;

    void menu() {
        background(227, 231, 175);
        // Titulo
        fill(0, 46, 44);
        textSize(24);
        text("Titulo", 290, 25, 80, 40);
        // fecha y hora
        textSize(18);
        text(String.valueOf(day()) + "/" + String.valueOf(month()) + "/" + String.valueOf(year()) + " - ", 10, 455, 130, 30);
        text(String.valueOf(hour()) + ":" + String.valueOf(minute()) + ":" + String.valueOf(second()), 140, 455, 100, 30);

        // Icono
//        ellipse(320, 180, 150, 150);
        fill(3, 94, 123); // Color        
        // Botones                
        // Left Buttons
        rect(-1, 280, 120, 40, 0, 15, 15, 0);
        rect(-1, 340, 120, 40, 0, 15, 15, 0);
        //Right Buttons        
        rect(520, 280, 120, 40, 15, 0, 0, 15);
        rect(520, 340, 120, 40, 15, 0, 0, 15);
        fill(239, 241, 197);
        textSize(20);
        text("Radar", 28, 288, 100, 40);
        text("Opcion 3", 22, 348, 100, 40);
        text("Opcion 2", 535, 288, 100, 40);
        text("Opcion 4", 535, 348, 100, 40);
        fill(162, 167, 127);
        // Exit and ... Buttons
        rect(540, 435, 80, 30, 10, 10, 10, 10);
        fill(0, 16, 14);
        textSize(16);
        text("Salir", 565, 440, 80, 25);

        textSize(20);
        if ((mouseX > -1) && (mouseX < 119) && (mouseY > 280) && (mouseY < 320)) {
            cursor(HAND);
            if (mousePressed) {
                fill(91, 139, 142);
                rect(-1, 280, 120, 40, 0, 15, 15, 0);
                fill(0);
                text("Radar", 28, 288, 100, 40);
                boton = true;
            }
        } else {
            cursor(ARROW);
        }

        if ((mouseX > 520) && (mouseX < 640) && (mouseY > 280) && (mouseY < 320) && (mousePressed)) {
            fill(91, 139, 142);
            rect(520, 280, 120, 40, 15, 0, 0, 15);
            fill(0);
//            text("Opcion 2", 535, 326, 100, 40);
            boton = true;
        }

        // Salir button
        if ((mouseX > 540) && (mouseX < 620) && (mouseY > 435) && (mouseY < 465) && (mousePressed)) {
            fill(91, 139, 142);
            rect(540, 435, 80, 30, 10, 10, 10, 10);
            fill(255);
            textSize(16);
            text("Salir", 565, 440, 80, 25);
//            exit();
        }

        if (botonSalir) {

        }
    }

    void animacion() {
        fill(228, 245, 255);
        rect(x, y, moveX, moveY);
        moveX += 4;
        if (moveX >= 610) {
            x += 4;
        }
        if (x >= 610) {
            x -= 4;
            moveY += 4;
        }
    }

}
