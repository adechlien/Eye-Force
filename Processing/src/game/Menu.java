package game;

import processing.core.PApplet;
import static processing.core.PApplet.atan2;
import processing.core.PFont;
import processing.core.PImage;

public class Menu extends PApplet {

    Eye e1, e2;
    PFont font;
    PImage icon;
    String disposeText, op1 = "Radar", op2, op3, op4, backText, regText;
    int add, hora = hour(), minuto = minute(), count = 0, x = 0, y = 10, moveX = 10, moveY = 10, rx;
    boolean on = false, switchEn = false, menu = true;
    float move;

    @Override
    public void settings() {
        size(720, 500);
    }

    @Override
    public void setup() {
        e1 = new Eye(270, 154, 72);
        e2 = new Eye(440, 154, 72);
        icon = loadImage("images/icon.png");
        font = loadFont("fontThree.vlw");
        surface.setIcon(icon);
        textFont(font);
    }

    @Override
    public void draw() {
        background(20, 33, 61);
        if (menu) {
            if (switchEn) {
                disposeText = "Exit";
                op2 = "Option";
                op3 = "Option";
                op4 = "Option";
            } else {
                disposeText = "Salir";
                op2 = "Opción";
                op3 = "Opción";
                op4 = "Opción";
            }
            options(disposeText, op1, op2, op3, op4);
            animation();
        } else {
            if (switchEn) {
                backText = "Back";
                regText = "Registration";
            } else {
                backText = "Atras";
                regText = "Registro";
            }
            radarMenu(backText);
            radarSwitch();
            registrationTable(regText);
            turningLines(add);
        }
    }

    public void run() {
        String[] processingArgs = {this.getClass().getName()};
        PApplet.runSketch(processingArgs, this);
    }

    void options(String disposeText, String op1, String op2, String op3, String op4) {
        background(20, 33, 61);
        // Languages
        strokeWeight(4);
        fill(229, 229, 229);
        textSize(20);
        text("EN | ES", 20, 20, 80, 20);
        // Title
        strokeWeight(2);
        textSize(26);
        text("Bebesita", 315, 25, 110, 40);
        // Date and Hour
        textSize(18);
        text(String.valueOf(day()) + "/" + String.valueOf(month()) + "/" + String.valueOf(year())
                + " - " + String.valueOf(hour()) + ":" + String.valueOf(minute()) + ":"
                + String.valueOf(second()), 15, 475, 250, 30);
        // Buttons
        strokeWeight(2);
        fill(229, 229, 229);
        textSize(20);
        // Left Buttons
        rect(-1, 280, 160, 40, 0, 15, 15, 0);
        rect(-1, 340, 120, 40, 0, 15, 15, 0);
        // Right Buttons        
        rect(600, 280, 120, 40, 15, 0, 0, 15);
        rect(560, 340, 160, 40, 15, 0, 0, 15);
        fill(0);
        // Texts
        text(op1, 48, 292, 100, 40);
        text(op3, 626, 293, 90, 40);
        text(op2, 24, 353, 90, 40);
        text(op4, 606, 353, 90, 40);        
        // Exit Button
        fill(255, 203, 47);
        rect(620, 455, 80, 30, 10, 10, 10, 10);        
        textSize(15);
        fill(0);
        text(disposeText, 645, 465, 80, 25);
        // Changes
        textSize(18);
        // Option 1
        if ((mouseX > -1) && (mouseX < 159) && (mouseY > 280) && (mouseY < 320)) {
            cursor(HAND);
            if (mousePressed) {
                fill(91, 139, 142);
                rect(-1, 280, 160, 40, 0, 15, 15, 0);
                fill(0);
                text(op1, 48, 292, 100, 40);
                menu = false;
            }
        } else {
            cursor(ARROW);
        }
        // Option 2
        if ((mouseX > 600) && (mouseX < 720) && (mouseY > 280) && (mouseY < 320) && (mousePressed)) {
            fill(91, 139, 142);
            rect(600, 280, 120, 40, 15, 0, 0, 15);
            fill(0);
            text(op2, 620, 293, 100, 40);
        }
        // Exit Button
        if ((mouseX > 620) && (mouseX < 720) && (mouseY > 455) && (mouseY < 485) && (mousePressed)) {
            fill(252, 163, 17);
            rect(620, 455, 80, 30, 10, 10, 10, 10);
            fill(0);
            textSize(15);
            text(disposeText, 645, 465, 80, 25);
            exit();
        }
        // Language Switch
        if ((mouseX > 20) && (mouseX < 50) && (mouseY > 19) && (mouseY < 39)) {
            cursor(HAND);
            if (mousePressed) {
                switchEn = true;
            }
        } else {
            if ((mouseX > 60) && (mouseX < 90) && (mouseY > 19) && (mouseY < 39)) {
                cursor(HAND);
                if (mousePressed) {
                    switchEn = false;
                }
            } else {
                cursor(ARROW);
            }
        }
    }

    void animation() {
        strokeWeight(4);
        fill(229, 229, 229);        
        // Left Eye        
        arc(270, 247, 220, 260, PI + QUARTER_PI, TAU - QUARTER_PI, OPEN);
        arc(270, 63, 220, 260, QUARTER_PI, HALF_PI + QUARTER_PI, OPEN);
        line(240, 120, 230, 110);
        line(270, 115, 270, 105);
        line(300, 120, 310, 110);
        // Right Eye        
        arc(440, 247, 220, 260, PI + QUARTER_PI, TAU - QUARTER_PI, OPEN);
        arc(440, 63, 220, 260, QUARTER_PI, HALF_PI + QUARTER_PI, OPEN);
        line(410, 120, 400, 110);
        line(440, 115, 440, 105);
        line(470, 120, 480, 110);
        // Re-drawing
        e1.update(mouseX, mouseY);
        e1.display();
        e2.update(mouseX, mouseY);
        e2.display();
    }

    void radarMenu(String backText) {
        // Back Button
        stroke(0);
        strokeWeight(2);
        fill(255, 203, 47);
        rect(20, 20, 70, 25, 10, 10, 10, 10);
        fill(0);
        textSize(16);
        text(backText, 36, 26, 40, 20);
        // Radar
        strokeWeight(1);
        stroke(190, 231, 209);
//        stroke(250, 21, 29); // Red color
        // Y-Axis and X-Axis
        line(250, 40, 250, 460);
        line(40, 250, 460, 250);
        // Diagonals
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
        // Decoration
        strokeWeight(4);       
        ellipse(250, 250, 350, 350);
        line(240, 250, 260, 250);
        line(250, 240, 250, 260);
        line(75, 250, 100, 250); // 1
        line(425, 250, 400, 250); // 2
        line(250, 75, 250, 100); // 3
        line(250, 425, 250, 400); // 4
        line(128, 128, 140, 140); // 1.1
        line(372, 128, 360, 140); // 2.1
        line(128, 372, 140, 360); // 3.1
        line(372, 372, 360, 360); // 4.1
        // Changes
        if ((mouseX > 20) && (mouseX < 90) && (mouseY > 20) && (mouseY < 55)) {
            cursor(HAND);
            if (mousePressed) {
                menu = true;
            }
        } else {
            cursor(ARROW);
        }
    }

    void radarSwitch() {
        // Buttons
        strokeWeight(1);
        stroke(0);
        // Red/Off
        fill(240, 155, 140);
        rect(422, 450, 40, 30, 0, 10, 10, 0);
        // Green/On
        fill(190, 231, 209);
        rect(380, 450, 40, 30, 10, 0, 0, 10);
        // Underline
        strokeWeight(3);
        noFill();
        if (on) {
            stroke(30, 255, 30);
            line(390, 485, 420, 485);
        } else {
            stroke(255, 30, 20);
            line(422, 485, 452, 485);
        }
        // Texts
        fill(0);
        textSize(14);
        text("On", 390, 470);
        text("Off", 430, 470);
        // Function
        if ((mouseX > 380) && (mouseX < 420) && (mouseY > 450) && (mouseY < 480) && (mousePressed)) {
            on = true;
            add = 1;
        } else {
            if ((mouseX > 422) && (mouseX < 462) && (mouseY > 450) && (mouseY < 480) && (mousePressed)) {
                on = false;
                add = 0;
            }
        }
    }

    void registrationTable(String regText) {
        // Tira la palanca y endereza... que la Guagua va en reversa
        strokeWeight(2);
        stroke(0);
        fill(229, 229, 229);
        textSize(20);
        // Title
        if ("Registration".equals(regText)) {
            rx = 555;
        } else {
            rx = 570;
        }
        text(regText, rx, 35, 120, 50);
        // Table
        rect(520, 60, 170, 400);
        for (int i = 100; i <= 430; i += 40) {
            strokeWeight(1);
            line(520, i, 690, i);
        }
        // Function
        fill(0);
        text(hora + ":" + minuto, 625, 75, 690, 100);
    }

    void turningLines(int add) {
        delay(50);
        count = count + add;
        move = count * (2 * PI) / 60;
        translate(250, 250);
        rotate(move);
        strokeWeight(5);
        int alpha = 255, moveY[] = {-185, -185, -185, -185, -184, -183, -183, -182,
            -181, -180, -178, -176, -174, -172}, k = 0;
        if (add == 1) {
            for (int i = 0; i > -70; i -= 5) {
                stroke(240, 40, 40, alpha);
                line(0, 0, i, moveY[k] + 10);
                alpha -= 15;
                k++;
            }
        } else {
            stroke(240, 40, 40);
            line(0, 0, 0, -175);
        }
        stroke(0);
    }

    class Eye {

        int x, y;
        int size;
        float angle = (float) 0.0;

        Eye(int tx, int ty, int ts) {
            x = tx;
            y = ty;
            size = ts;
        }

        void update(int mx, int my) {
            angle = atan2(my - y, mx - x);
        }

        void display() {
            pushMatrix();
            translate(x, y);
            fill(255);
            ellipse(0, 0, size, size);
            rotate(angle);
            fill(20);
            ellipse(size / 4, 0, size / 2, size / 2);
            popMatrix();
        }
    }
}
