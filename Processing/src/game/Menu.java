package game;

import static processing.core.PApplet.atan2;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Menu extends PApplet {

    Eye e1, e2;
    PFont font;
    PImage icon, photo, moonIcon, sunIcon, pShield;
    String language = "ES", op1 = "Radar", op2, op3, op4;
    String disposeText, backText, hisText, lgText, useText;
    int hora = hour(), minuto = minute(), count = 0, x = 0, y = 10;
    int add, disposeX, backX, hisX, lgX, op4X, useX, tab = 0;
    boolean on = false, lgBoard = false, darkMode = false;
    float move;

    @Override
    public void settings() {
        size(720, 500);
    }

    @Override
    public void setup() {
        e1 = new Eye(290, 155, 85);
        e2 = new Eye(430, 155, 85);
        icon = loadImage("images/icon.png");
        font = loadFont("fontThree.vlw");
        photo = loadImage("images/owl.png");
        moonIcon = loadImage("images/moon.png");
        sunIcon = loadImage("images/sun.png");
        pShield = loadImage("images/pShield.png");
        surface.setIcon(icon);
        textFont(font);
    }

    @Override
    public void draw() {
        switch (language) {
            case "EN":
                lgText = "Language";
                disposeText = "Exit";
                op2 = "Option";
                op3 = "Option";
                op4 = "Instructions";
                backText = "Back";
                hisText = "History";
                useText = "How to use";
                break;
            case "ES":
                lgText = "Idioma";
                disposeText = "Salir";
                op2 = "Opción";
                op3 = "Opción";
                op4 = "Instrucciones";
                backText = "Atrás";
                hisText = "Historial";
                useText = "Cómo usar";
                break;
            case "IT":
                lgText = "Lingua";
                disposeText = "Uscita";
                op2 = "Opzione";
                op3 = "Opzione";
                op4 = "Istruzioni";
                backText = "Indietro";
                hisText = "Storia";
                useText = "Modalità d'uso";
                break;
            case "FR":
                lgText = "Langue";
                disposeText = "Sortie";
                op2 = "Option";
                op3 = "Option";
                op4 = "Instructions";
                backText = "Revenir";
                hisText = "Histoire";
                useText = "Mode d’emploi";
                break;
            case "DE":
                lgText = "Sprache";
                disposeText = "Verlassen";
                op2 = "Option";
                op3 = "Option";
                op4 = "Anweisungen";
                backText = "Zurück";
                hisText = "Bewegungsprofil";
                useText = "Gebrauchsanleitung";
                break;
            case "PR":
                lgText = "Idioma";
                disposeText = "Saída";
                op2 = "Opção";
                op3 = "Opção";
                op4 = "Instruções";
                backText = "Voltar";
                hisText = "História";
                useText = "Como usar";
                break;
        }
        switch (tab) {
            case 0:
                if (darkMode) {
                    background(50, 63, 121);
                } else {
                    background(230, 230, 250);
                }
                mainMenu(disposeText, op1, op2, op3, op4);
                languageSelection();
                animation();
                break;
            case 1:
                if (darkMode) {
                    background(45, 58, 106);
                } else {
                    background(230, 230, 250);
                }
                radarMenu(backText);
                radarSwitch();
                historyTable(hisText);
                turningLines(add);
                break;
            case 2:
                if (darkMode) {
                    background(50, 63, 121);
                } else {
                    background(230, 230, 250);
                }
                infoPage(backText);
                break;
        }
    }

    public void run() {
        String[] processingArgs = {this.getClass().getName()};
        PApplet.runSketch(processingArgs, this);
    }

    // Menu Tab
    void mainMenu(String disposeText, String op1, String op2, String op3, String op4) {
        // Title
        textSize(26);
        if (darkMode) {
            fill(229);
        } else {
            fill(50, 63, 121);
        }
        text("Owlt", 333, 25, 110, 40);
        // Date and Hour
        textSize(18);
        text(String.valueOf(day()) + "/" + String.valueOf(month()) + "/" + String.valueOf(year())
                + " - " + String.valueOf(hour()) + ":" + String.valueOf(minute()) + ":"
                + String.valueOf(second()), 15, 475, 250, 30);
        // Buttons
        strokeWeight(3);
        textSize(20);
        // Left Buttons
        rect(-1, 280, 160, 40, 0, 5, 15, 0);
        rect(-1, 340, 120, 40, 0, 5, 15, 0);
        // Right Buttons        
        rect(600, 280, 120, 40, 15, 0, 0, 5);
        rect(560, 340, 160, 40, 15, 0, 0, 5);
        if (darkMode) {
            fill(0);
        } else {
            fill(229);
        }
        // Texts
        text(op1, 48, 293, 100, 40);
        text(op3, 626, 293, 90, 40);
        text(op2, 24, 353, 90, 40);
        switch (op4) {
            case "Anweisungen":
                op4X = 580;
                break;
            case "Instrucciones":
                op4X = 582;
                break;
            case "Instructions":
                op4X = 585;
                break;
            case "Istruzioni":
            case "Instruções":
                op4X = 595;
                break;
        }
        text(op4, op4X, 353, 140, 40);
        // Exit Button
        fill(255, 203, 47);
        rect(620, 455, 80, 30, 5, 10, 5, 10);
        textSize(15);
        fill(0);
        switch (disposeText) {
            case "Verlassen":
                disposeX = 628;
                break;
            case "Uscita":
                disposeX = 640;
                break;
            case "Sortie":
            case "Saída":
                disposeX = 642;
                break;
            case "Salir":
            case "Exit":
                disposeX = 645;
                break;
        }
        text(disposeText, disposeX, 465, 80, 25);
        // Dark and Light Modes
        textSize(18);
        fill(50, 63, 121);
        rect(600, 30, 40, 30, 10, 0, 0, 5);
        fill(230, 230, 250);
        rect(641, 30, 40, 30, 0, 5, 10, 0);
        image(moonIcon, 613, 37);
        image(sunIcon, 652, 35);
        if ((mouseX > 600) && (mouseX < 640) && (mouseY > 30) && (mouseY < 60)) {
            cursor(HAND);
            if (mousePressed) {
                darkMode = true;
            }
        } else if ((mouseX > 640) && (mouseX < 680) && (mouseY > 30) && (mouseY < 60)) {
            cursor(HAND);
            if (mousePressed) {
                darkMode = false;
            }
        }
        // Changes
        textSize(18);
        // Option 1
        if ((mouseX > -1) && (mouseX < 159) && (mouseY > 280) && (mouseY < 320)) {
            cursor(HAND);
            if (mousePressed) {
                tab = 1;
            }
        } else {
            cursor(ARROW);
        }
        // Option 2
//        if ((mouseX > 600) && (mouseX < 720) && (mouseY > 280) && (mouseY < 320) && (mousePressed)) {
//
//        }
        // Option 4
        if ((mouseX > 560) && (mouseX < 720) && (mouseY > 340) && (mouseY < 380)) {
            cursor(HAND);
            if (mousePressed) {
                tab = 2;
            }
        }
        // Exit Button
        if ((mouseX > 620) && (mouseX < 720) && (mouseY > 455) && (mouseY < 485)) {
            cursor(HAND);
            if (mousePressed) {
                exit();
            }
        }
    }

    void languageSelection() {
        // Board
        strokeWeight(3);
        fill(255, 203, 47);
        rect(30, 30, 100, 30, 10, 5, 10, 5);
        textSize(16);
        fill(0);
        switch (lgText) {
            case "Language":
                lgX = 45;
                break;
            case "Sprache":
                lgX = 53;
                break;
            case "Idioma":
            case "Lingua":
            case "Langue":
                lgX = 55;
                break;
        }
        text(lgText, lgX, 40, 100, 20);
        // Function
        if ((mouseX > 30) && (mouseX < 130) && (mouseY > 30) && (mouseY < 60) && (mousePressed)) {
            lgBoard = true;
        } else {
            if (!((mouseX > 30) && (mouseX < 130) && (mouseY > 30) && (mouseY < 245))) {
                lgBoard = false;
            }
        }
        if (lgBoard) {
            fill(0);
            rect(30, 65, 100, 180, 5, 10, 10, 10);
            strokeWeight(3);
            // UK Flag
            // Blue
            fill(69, 123, 157);
            rect(30, 65, 100, 30, 10, 10, 10, 10);
            // White
            strokeWeight(0);
            fill(241, 250, 238);
            rect(70, 67, 20, 26);
            rect(32, 75, 97, 10);
            stroke(241, 250, 238);
            strokeWeight(5);
            line(35, 70, 125, 90);
            line(35, 90, 125, 70);
            // Red
            strokeWeight(0);
            fill(230, 57, 70);
            rect(75, 67, 10, 26);
            rect(32, 78, 97, 4);
            stroke(230, 57, 70);
            strokeWeight(2);
            line(33, 69, 127, 91);
            line(33, 91, 127, 69);
            // Spain Flag
            // Red
            stroke(0);
            strokeWeight(2);
            fill(199, 3, 24);
            rect(30, 95, 100, 30, 10, 10, 10, 10);
            // Yellow
            strokeWeight(0);
            fill(252, 223, 0);
            rect(32, 104, 97, 13);
            // La bandiera di Italia
            // Green
            stroke(4);
            fill(106, 153, 78);
            rect(31, 127, 33, 27, 10, 0, 0, 10);
            // White
            fill(242, 232, 207);
            rect(63, 127, 34, 27);
            // Red
            fill(239, 35, 60);
            rect(97, 127, 33, 27, 0, 10, 10, 0);
            // France Flag
            // Blue
            fill(0, 60, 136);
            rect(31, 157, 33, 27, 10, 0, 0, 10);
            // White
            fill(242, 232, 207);
            rect(63, 157, 34, 27);
            // Red
            fill(239, 35, 60);
            rect(97, 157, 33, 27, 0, 10, 10, 0);
            // Germany Flag
            // Black
            fill(25);
            rect(31, 187, 99, 9, 15, 15, 0, 0);
            // Red
            fill(208, 0, 0);
            rect(31, 196, 99, 9);
            // Yellow
            fill(255, 186, 8);
            rect(31, 205, 99, 9, 0, 0, 15, 15);
            // Portugal Flag
            // Green
            fill(41, 171, 28);
            rect(31, 217, 42, 27, 10, 0, 0, 10);
            // Red
            fill(242, 27, 63);
            rect(73, 217, 57, 27, 0, 10, 10, 0);
            // Shield
            image(pShield, 62, 220);
            // Border
            noFill();
            stroke(3);
            strokeWeight(3);
            rect(30, 30, 100, 30, 10, 5, 10, 5);
            strokeWeight(3);
            for (int i = 95; i < 240; i += 30) {
                fill(0);
                line(30, i, 130, i);
            }
            if (darkMode) {
                fill(229);
            } else {
                fill(50, 63, 121);
            }
            if ((mouseX > 30) && (mouseX < 130) && (mouseY > 65) && (mouseY < 95)) {
                textSize(16);
                text("English", 140, 85);
                if (mousePressed) {
                    language = "EN";
                }
            } else {
                if ((mouseX > 30) && (mouseX < 130) && (mouseY > 95) && (mouseY < 125)) {
                    text("Español", 140, 115);
                    if (mousePressed) {
                        language = "ES";
                    }
                } else {
                    if ((mouseX > 30) && (mouseX < 130) && (mouseY > 125) && (mouseY < 155)) {
                        text("Italiano", 140, 145);
                        if (mousePressed) {
                            language = "IT";
                        }
                    } else {
                        if ((mouseX > 30) && (mouseX < 130) && (mouseY > 155) && (mouseY < 185)) {
                            text("Français", 140, 175);
                            if (mousePressed) {
                                language = "FR";
                            }
                        } else {
                            if ((mouseX > 30) && (mouseX < 130) && (mouseY > 185) && (mouseY < 215)) {
                                text("Deutsch", 140, 205);
                                if (mousePressed) {
                                    language = "DE";
                                }
                            } else {
                                if ((mouseX > 30) && (mouseX < 130) && (mouseY > 215) && (mouseY < 265)) {
                                    text("Português", 140, 235);
                                    if (mousePressed) {
                                        language = "PR";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void animation() {
        stroke(0);
        strokeWeight(4);
        fill(229, 229, 229);
        // Re-drawing
        if (darkMode) {
            e1.update(mouseX, mouseY);
            e1.display();
            e2.update(mouseX, mouseY);
            e2.display();
        } else {
            fill(150);
            ellipse(295, 150, 80, 80);
            ellipse(425, 150, 80, 80);
            strokeWeight(2);
            arc(295, 150, 60, 60, QUARTER_PI, PI);
            arc(425, 150, 60, 60, 0, PI - QUARTER_PI);
        }
        image(photo, 210, 0);
    }

    // Radar Tab
    void radarMenu(String backText) {
        // Back Button
        stroke(0);
        strokeWeight(3);
        fill(255, 203, 47);
        rect(20, 20, 85, 30, 10, 5, 10, 5);
        fill(0);
        textSize(16);
        switch (backText) {
            case "Indietro":
            case "Revenir":
                backX = 34;
                break;
            case "Zurück":
                backX = 38;
                break;
            case "Voltar":
                backX = 40;
                break;
            case "Atrás":
                backX = 42;
                break;
            case "Back":
                backX = 44;
                break;
        }
        text(backText, backX, 30, 70, 20);
        // Radar
        strokeWeight(1);
        if (darkMode) {
            stroke(190, 231, 209);
        } else {
            stroke(46, 125, 85);
        }
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
        line(75, 250, 100, 250);
        line(425, 250, 400, 250);
        line(250, 75, 250, 100);
        line(250, 425, 250, 400);
        line(128, 128, 140, 140);
        line(372, 128, 360, 140);
        line(128, 372, 140, 360);
        line(372, 372, 360, 360);
        // Distance
        strokeWeight(1);
        if (darkMode) {
            fill(190, 231, 209);
        } else {
            fill(46, 125, 85);
        }
        textSize(15);
//        text("2", 280, 248);
        text("10", 314, 246);
        text("20", 354, 246);
        text("30", 392, 246);
        text("40", 430, 246);
        // Changes
        if ((mouseX > 20) && (mouseX < 90) && (mouseY > 20) && (mouseY < 55)) {
            cursor(HAND);
            if (mousePressed) {
                tab = 0;
            }
        } else {
            cursor(ARROW);
        }
    }

    void radarSwitch() {
        // Buttons
        strokeWeight(3);
        stroke(0);
        // Red/Off
        fill(255, 155, 140);
        rect(422, 450, 40, 30, 0, 10, 10, 0);
        // Green/On
        fill(160, 255, 179);
        rect(380, 450, 40, 30, 10, 0, 0, 10);
        // Underline
        strokeWeight(3);
        noFill();
        // Texts
        fill(0);
        textSize(14);
        text("On", 391, 470);
        text("Off", 431, 470);
        // Function
        if ((mouseX > 380) && (mouseX < 420) && (mouseY > 450) && (mouseY < 480)) {
            cursor(HAND);
            if (mousePressed) {
                on = true;
                add = 1;
            }
        } else {
            if ((mouseX > 422) && (mouseX < 462) && (mouseY > 450) && (mouseY < 480) && (mousePressed)) {
                cursor(HAND);
                if (mousePressed) {
                    on = false;
                    add = 0;
                }
            } else {
                cursor(ARROW);
            }
        }
    }

    void historyTable(String hisText) {        
        strokeWeight(3);
        stroke(0);
        if (darkMode) {
            fill(229);
        } else {
            fill(50, 63, 121);
        }
        textSize(20);
        // Title
        switch (hisText) {
            case "Bewegungsprofil":
                hisX = 528;
                break;
            case "History":
            case "Historial":
            case "Histoire":
            case "História":
                hisX = 570;
                break;
            case "Storia":
                hisX = 580;
                break;
        }
        text(hisText, hisX, 35, 160, 50);
        // Table
        fill(229);
        rect(520, 60, 170, 400, 10, 10, 10, 10);
        for (int i = 100; i <= 430; i += 40) {
            strokeWeight(1);
            line(520, i, 690, i);
        }
        // Function
        fill(0);
        text(hora + ":" + minuto, 625, 75, 690, 100);
    }

    void turningLines(int add) {
        delay(40);
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

    // Code taken from "Mouse Arc Tangent", a Processing starting project.
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
            fill(255, 255, 147);
            ellipse(0, 0, size, size);
            rotate(angle);
            fill(20);
            ellipse(size / 4, 0, size / 2, size / 2);
            popMatrix();
        }
    }

    // Info Tab
    void infoPage(String backText) {
        if (darkMode) {
            fill(229);
        } else {
            fill(50, 63, 121);
        }
        // Title
        textSize(25);
        switch (useText) {
            case "Cómo usar":
            case "How to use":
            case "Como usar":
                useX = 300;
                break;
            case "Modalità d'uso":
            case "Mode d’emploi":
                useX = 280;
                break;
            case "Gebrauchsanleitung":
                useX = 260;
                break;
        }
        text(useText, useX, 15, 240, 40);
        rect(20, 40, 680, 440, 5, 10, 5, 10);
        // Back Button
        stroke(0);
        strokeWeight(3);
        fill(255, 203, 47);
        rect(20, 450, 85, 30, 5, 10, 5, 10);
        fill(0);
        textSize(16);
        switch (backText) {
            case "Indietro":
            case "Revenir":
                backX = 34;
                break;
            case "Zurück":
                backX = 38;
                break;
            case "Voltar":
                backX = 40;
                break;
            case "Atrás":
            case "Back":
                backX = 42;
                break;
        }
        text(backText, backX, 460, 70, 20);
        // Explanation
        if (darkMode) {
            fill(50, 63, 121);
        } else {
            fill(229);
        }
        textSize(22);
        text("To start the radar, click on Radar Button", 40, 80);
        // Changes
        if ((mouseX > 20) && (mouseX < 105) && (mouseY > 450) && (mouseY < 480)) {
            cursor(HAND);
            if (mousePressed) {
                tab = 0;
            }
        } else {
            cursor(ARROW);
        }
    }

}
