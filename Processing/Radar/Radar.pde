import static processing.core.PApplet.atan2; 
import processing.core.PApplet; 
import processing.core.PFont; 
import processing.core.PImage; 
import processing.serial.*; // imports library for serial communication 
import java.awt.event.KeyEvent; // imports library for reading the data from the serial port 
import java.io.IOException; 
Serial myPort; // defines Object Serial 
// defubes variables 
String angle=""; 
String distance=""; 
String port=""; 
String noObject; 
float pixsDistance; 
int iAngle, iDistance; 
int index1=0; 
int index2=0;

Eye e1, e2;
PFont font;
PImage icon, photo, moonIcon, sunIcon;
String language = "ES", op1, op2, op3 = "Radar", op4;
String disposeText, backText, hisText, lgText, useText;
int hora = hour(), minuto = minute(), count = 0, x = 0, y = 10;
int add, disposeX, backX, hisX, lgX, op1X, op4X, useX, tab = 0;
boolean on = false, lgBoard = false, darkMode = false;
float move;  

void setup(){
  size(720, 500);
  e1 = new Eye(290, 155, 85); 
  e2 = new Eye(430, 155, 85); 
  icon = loadImage("images/icon.png"); 
  font = loadFont("fontThree.vlw"); 
  photo = loadImage("images/owl.png"); 
  moonIcon = loadImage("images/moon.png"); 
  sunIcon = loadImage("images/sun.png");
  surface.setIcon(icon); 
  textFont(font);
  smooth();
  //myPort = new Serial(this,"COM3", 9600); // starts the serial communication
  //myPort.bufferUntil('.');
} 

void draw() {
  switch (language) {
    case "EN":
      lgText = "Language";
      disposeText = "Exit";
      op1 = "History";
      op2 = "Option";
      op4 = "Instructions";
      backText = "Back";
      hisText = "History";
      useText = "How to use";
      break;
    case "ES":
      lgText = "Idioma";
      disposeText = "Salir";
      op1 = "Historial";
      op2 = "Opción";
      op4 = "Instrucciones";
      backText = "Atrás";
      hisText = "Historial";
      useText = "Cómo usar";
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
      case 1: // ventana de historial
      if (darkMode) {
          background(50, 63, 121);
        } else {
          background(230, 230, 250);
        }
        backButton(backText);
        miniRadar();
        historyTable(hisText);
        break;
      case 2: // ventana de radar
        radarBg();
        radar();
        redLine();
        radarLine();
        backButton(backText);        
        break;
      case 3: // ventana de instrucciones
        if (darkMode) {
          background(50, 63, 121);
        } else {
          background(230, 230, 250);
        }
        infoPage(backText);
        break;               
    }
}

// Arduino
void serialEvent (Serial myPort) { // starts reading data from the Serial Port 
  // reads the data from the Serial Port up to the character '.' and puts it into the String variable "data". 
  port = myPort.readStringUntil('.'); 
  port = port.substring(0,port.length()-1); 
  index1 = port.indexOf(","); // find the character ',' and puts it into the variable "index1" 
  angle= port.substring(0, index1); // read the data from position "0" to position of the variable index1 or thats the value of the angle the Arduino Board sent into the Serial Port 
  distance= port.substring(index1+1, port.length()); // read the data from position "index1" to the end of the data pr thats the value of the distance 
  // converts the String variables into Integer 
  iAngle = int(angle); 
  iDistance = int(distance);
} 

// 0. Menu    
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
  strokeWeight(2);
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
  switch (op1) {
    case "Historial":
      op1X = 38;
      break;
    case "History":
      op1X = 42;
      break;
  }
  text(op1, op1X, 293, 100, 40);
  text(op3, 626, 293, 90, 40);
  text(op2, 32, 353, 90, 40);
  switch (op4) {
    case "Instrucciones":
      op4X = 582;
      break;
    case "Instructions":
      op4X = 585;
      break;
  }
  text(op4, op4X, 353, 140, 40);
  // Exit Button
  fill(255, 203, 47);
  rect(620, 455, 80, 30, 5, 10, 5, 10);
  textSize(15);
  fill(0);
  text(disposeText, 645, 465, 80, 25);
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
  if ((mouseX > 600) && (mouseX < width) && (mouseY > 280) && (mouseY < 320)) {
    cursor(HAND);
    if (mousePressed) {
      tab = 2;
    }
  } else {
    cursor(ARROW);
  }
  // Option 4
  if ((mouseX > 560) && (mouseX < width) && (mouseY > 340) && (mouseY < 380)) {
    cursor(HAND);
    if (mousePressed) {
      tab = 3;
    }
  }
  // Exit Button
  if ((mouseX > 620) && (mouseX < width) && (mouseY > 455) && (mouseY < 485)) {
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
    case "Idioma":
      lgX = 55;
      break;
  }
  text(lgText, lgX, 40, 100, 20);
  // Function
  if ((mouseX > 30) && (mouseX < 130) && (mouseY > 30) && (mouseY < 60) && (mousePressed)) {
    lgBoard = true;
  } else if (!((mouseX > 30) && (mouseX < 130) && (mouseY > 30) && (mouseY < 130))) {
    lgBoard = false;
  }        
  if (lgBoard) {
    fill(0);
    rect(30, 65, 100, 60, 5, 10, 10, 10);
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
    // Border
    noFill();
    stroke(3);
    strokeWeight(3);
    rect(30, 30, 100, 30, 10, 5, 10, 5);
    strokeWeight(3);
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
      }                                    
    }
  }
}

void animation() {
  stroke(0);
  strokeWeight(4);
  fill(229);
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

void iconRadar() {
  if (darkMode) {
    stroke(229);
  } else {
    stroke(50, 63, 121);
  }
  noFill();
  strokeWeight(2);
  for(int i = 25; i <= 75; i+= 25) {
    ellipse(width / 2, width / 2, i, i);
  }        
  line(width / 2, 310, width / 2, 410);
  line(310, width / 2, 410, width / 2);        
  line(340, 340, 345, 345);
  line(375, 345, 380, 340);
  line(375, 375, 380, 380);
  line(340, 380, 345, 375);
        
  strokeWeight(4);
  ellipse(width / 2, width / 2, 100, 100);
  line(310, width / 2, 320, width / 2);
  line(400, width / 2, 410, width / 2);
  line(width / 2, 310, width / 2, 320);
  line(width / 2, 400, width / 2, 410);
        
  line(325, 325, 330, 330);
  line(395, 325, 390, 330);
  line(325, 395, 330, 390);
  line(395, 395, 390, 390);
       
  stroke(240, 20, 20);
  line(width / 2, width / 2, width / 2, 310);
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

// 1. Historial
void miniRadar() {
        strokeWeight(1);
        if (darkMode) {
            stroke(190, 231, 209);
        } else {
            stroke(46, 125, 85);
        }      
        // Y-Axis and X-Axis
        line(570, 250, 570, 450);
        line(470, 350, 670, 350);
        // Diagonals
        line(535, 315, 540, 320);
        line(605, 315, 600, 320);
        line(535, 385, 540, 380);
        line(605, 385, 600, 380);
        // Circles
        noFill();
        arc(570, 350, 192, 192, 0, QUARTER_PI);
        arc(570, 350, 192, 192, HALF_PI, PI - QUARTER_PI);
        arc(570, 350, 192, 192, PI, PI + QUARTER_PI);
        arc(570, 350, 192, 192, PI + HALF_PI, TWO_PI - QUARTER_PI);
        for (int i = 0; i <= 135; i += 45) {
            ellipse(570, 350, i, i);
        }
        // Decoration
        strokeWeight(4);
        ellipse(570, 350, 180, 180);
        line(565, 350, 575, 350);
        line(570, 345, 570, 355);
        line(480, 350, 485, 350);
        line(655, 350, 660, 350);
        line(570, 260, 570, 265);
        line(570, 435, 570, 440);
        line(507, 287, 512, 292);
        line(633, 287, 628, 292);
        line(507, 413, 512, 408);
        line(633, 413, 628, 408);
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
  text(hisText, width/2-35, 45, 120, 50);
  // Table
  fill(229);
  rect(25, 80, 670, 150, 10, 10, 10, 10);
  for (int i = 167; i <= 620; i += 127) {
    strokeWeight(1);
    line(i, 85, i, 225);
  }
  line(50, 155, 670, 155);
  // Function
  fill(0);
  text(hora + ":" + minuto, 60, 90, 60, 30);
}

void backButton(String backText) {
  // Back Button
  stroke(0);
  strokeWeight(3);
  fill(255, 203, 47);
  rect(20, 20, 85, 30, 10, 5, 10, 5);
  fill(0);
  textSize(16);
  switch (backText) {
    case "Atrás":
      backX = 42;
      break;
    case "Back":
      backX = 44;
      break;
  }
  text(backText, backX, 30, 70, 20);  
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

// 2. Radar
void radarBg(){
  noFill();
  stroke(14);
  strokeWeight(80);
  arc(width/2, 440, 746, 700, PI, TAU);
  noStroke();
  fill(14);
  rect(0, 0, width, 124);
  rect(0, 465, width, 500);        
  rect(0, 0, 20, 500, 10);
  rect(700, 0, 20, 500);
  rect(20, 124, 50, 100);
  rect(650, 124, 50, 100);
  rect(60, 110, 60, 60);
  rect(600, 100, 60, 70);
  fill(0, 9);         
  rect(0, 0, width, height); 
  fill(46, 125, 85); 
}

void radar() { // semicirculos y lineas estaticas
  pushMatrix();
  translate(width/2,height-height*0.074); // moves the starting coordinats to new location
  noFill();
  strokeWeight(1);
  stroke(255);
  // draws the arc lines  
  arc(0,0,(width-width*0.27),(width-width*0.27),PI,TWO_PI);
  arc(0,0,(width-width*0.479),(width-width*0.479),PI,TWO_PI);
  arc(0,0,(width-width*0.687),(width-width*0.687),PI,TWO_PI);
  // draws the angle lines
  line(-120, -120, -150, -150);
  line(120, -120, 150, -150);
  //line(0,0,(-width/2 + 20)*cos(radians(30)),(-width/2 + 25)*sin(radians(30)));
  //line(0,0,(-width/2)*cos(radians(60)),(-width/2 + 28)*sin(radians(60)));
  line(0,0,(-width/2)*cos(radians(90)),(-width/2 + 22)*sin(radians(90)));
  //line(0,0,(-width/2)*cos(radians(120)),(-width/2 + 28)*sin(radians(120)));
  //line(0,0,(-width/2 + 20)*cos(radians(150)),(-width/2 + 25)*sin(radians(150)));
  //line((-width/2)*cos(radians(30)),0,width/2,0);
  strokeWeight(5);
  arc(0,0,(width-width*0.0625),(width-width*0.0625),PI,TWO_PI);
  line(0, (-width/2 + 22)*sin(radians(90)), 0,(-width/2 + 60)*sin(radians(90)));
  line(-width/2 + 22, 0, width/2 - 22, 0);
  line(-218, -218, -238, -238);
  line(218, -218, 238, -238);
  line(0, 0, 0, -20);
  line(-20, 0, 20, 0);
  popMatrix();
}

void redLine() { // linea dinamica roja
  pushMatrix();
  translate(width/2,height-height*0.074); // moves the starting coordinats to new location
  strokeWeight(10);
  stroke(255, 0, 0); // color del borde
  pixsDistance = iDistance*((height-height*0.1666)*0.025); // covers the distance from the sensor from cm to pixels
  // limiting the range to 40 cms
  if(iDistance<30){
    // draws the object according to the angle and the distance
  line(pixsDistance*cos(radians(iAngle)),-pixsDistance*sin(radians(iAngle)),(width-width*0.535)*cos(radians(iAngle)),-(width-width*0.535)*sin(radians(iAngle)));
  }
  popMatrix();
}

void radarLine() { // linea dinamica verde
  pushMatrix();
  strokeWeight(4);
  stroke(255);
  translate(width/2,height-height*0.074); // moves the starting coordinats to new location
  line(0,0,(height-height*0.32)*cos(radians(iAngle)),-(height-height*0.32)*sin(radians(iAngle))); // draws the line according to the angle
  popMatrix();
}

// 3. Instrucciones

void infoPage(String backText) {
  if (darkMode) {
    fill(229);
  } else {
    fill(50, 63, 121);
  }
  // Title
  textSize(25);
  text(useText, 300, 15, 240, 40);
  rect(20, 40, 680, 440, 5, 10, 5, 10);
  // Back Button
  stroke(0);
  strokeWeight(3);
  fill(255, 203, 47);
  rect(20, 450, 85, 30, 5, 10, 5, 10);
  fill(0);
  textSize(16);
  text(backText, 42, 460, 70, 20);
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
