import static processing.core.PApplet.atan2;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.serial.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import ddf.minim.*;
Serial myPort;

Eye e1, e2;
Minim minim;
AudioPlayer player;
PFont font;
PImage icon, photo, moonIcon, sunIcon, owl2, inst, desc;
String time[][] = {{"", "", "", "", ""}, {"", "", "", "", ""}}, pass = "3254";
String language = "ES", password = "  ", angle = "", distance = "", port = "", put = "";
String op1, op2 = "Radar", op3, op4, disposeText, backText, hisText, lgText, useText, pText;
boolean on = false, lgBoard = false, darkMode = false, pb = false, d1 = true, d2 = false, d3 = false, d4 = false, p1 = true, p2 = true, p3 = true, p4 = true;
int x = 0, y = 10, add, tab = 0, angleInt = 0, distanceInt= 0, index = 0, i = 0, j = 0, num1 = -1, num2 = -1, num3 = -1, num4 = -1, c=0;
int disposeX, backX, hisX, lgX, op1X, op3X, op4X = 590, useX, dX, pX;
float move, dPixels;

void setup() {
  size(720, 500);
  e1 = new Eye(290, 155, 85);
  e2 = new Eye(430, 155, 85);
  icon = loadImage("images/icon.png");
  font = loadFont("fontThree.vlw");
  photo = loadImage("images/owl.png");
  moonIcon = loadImage("images/moon.png");
  sunIcon = loadImage("images/sun.png");
  owl2 = loadImage("images/staticOwl.png");
  inst = loadImage("images/inst.png");
  desc = loadImage("images/desc.png");
  surface.setIcon(icon);
  textFont(font);
  smooth();
  minim = new Minim(this);
  player = minim.loadFile("sonido.wav");
  
  myPort = new Serial(this,"COM5", 9600);
  myPort.bufferUntil('.');
}

void draw() {
  switch (language) {
  case "EN":
    lgText = "Language";
    disposeText = "Exit";
    op1 = "Instructions";
    op3 = "History";
    op4 = "Description";
    backText = "Back";
    hisText = "Last 10 alerts";
    useText = "How to use";
    pText = "Password";
    break;
  case "ES":
    lgText = "Idioma";
    disposeText = "Salir";
    op1 = "Instrucciones";
    op3 = "Historial";
    op4 = "Descripción";
    backText = "Atrás";
    hisText = "Últimas 10 alertas";
    useText = "Cómo usar";
    pText = "Contraseña";
    break;
  }
  switch (tab) {
  case 0: // Menu
    if (darkMode) {
      background(50, 63, 121);
    } else {
      background(230, 230, 250);
    }
    mainMenu(disposeText, op1, op2, op3, op4);
    languageSelection();
    animation();
    iconRadar();
    break;
  case 1: // Instructions
    if (darkMode) {
      background(50, 63, 121);
    } else {
      background(230, 230, 250);
    }
    infoPage();
    backButton(backText);
    break;
  case 2: // Radar
    radarBg();
    radar();
    redLine();
    radarLine();
    backButton(backText);
    alarm();
    passwordBoard();
    break;
  case 3: // History
    if (darkMode) {
      background(50, 63, 121);
    } else {
      background(230, 230, 250);
    }
    backButton(backText);
    historyTable(hisText);
    hours();
    break;
  case 4: // Description
    if (darkMode) {
      background(50, 63, 121);
    } else {
      background(230, 230, 250);
    }
    descPanel();
    backButton(backText);
    break;
  }
}



// Alarm
void alarm() {
  if (player.isPlaying()) {
    if (concatPass(num1, num2, num3, num4) == "3254") {
      player.pause();
     
    } else {
      player.play();
      
    }
  }
}

//recursividad aplicada
void audioRec() {
  player.play();
  if (password == "3254") {
    player.pause();
  } else {
    audioRec();
  }
}

void keyPressed() {
  if (pb) {
    int number = getNumberEntered();
    if (num1 == -1) num1 = number;
    else if (num2 == -1) num2 = number;
    else if (num3 == -1) num3 = number;
    else if (num4 == -1) {num4 = number;
    //rectificar la validez de la contraseña
    println(concatPass(num1, num2, num3, num4));}
    else if ("3254" ==  concatPass(num1, num2, num3, num4)) {
      //LA CONTRASEÑA ES BUENA
      println("CONTRASEÑA INCORRECTA");
      
    } else {
      //LA CONTRASEÑA ES MAlA
       println("CONTRASEÑA CORRECTA");
      num1 = num2 = num3 = num4 = -1;
      player.pause();
      
     
    }
  }
}
