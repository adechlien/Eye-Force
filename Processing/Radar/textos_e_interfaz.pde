// 0. Menu
void mainMenu(String disposeText, String op1, String op2, String op3, String op4) {
  // Title
  textSize(26);
  if (darkMode) {
    fill(229);
  } else {
    fill(50, 63, 121);
  }
  text("Eye-Force", 300, 25, 120, 40);
  // Date and Hour
  textSize(18);
  text(String.valueOf(day()) + "/" + String.valueOf(month()) + "/" + String.valueOf(year())
    + " - " + String.valueOf(hour()) + ":" + String.valueOf(minute()) + ":"
    + String.valueOf(second()), 15, 475, 250, 30);
  // Buttons
  strokeWeight(2);
  textSize(20);
  // Left Buttons
  rect(-1, height/2 + 30, 160, 40, 0, 5, 15, 0);
  rect(-1, height/2 + 90, 120, 40, 0, 5, 15, 0);
  // Right Buttons
  rect(width - 120, 280, 120, 40, 15, 0, 0, 5);
  rect(width - 160, 340, 160, 40, 15, 0, 0, 5);
  if (darkMode) {
    fill(0);
  } else {
    fill(229);
  }
  // Texts
  switch (op1) {
  case "Instrucciones":
    op1X = 20;
    break;
  case "Instructions":
    op1X = 24;
    break;
  }
  text(op1, op1X, 293, 140, 40);
  text(op2, 632, 293, 90, 40);
  text(op4, op4X, 353, 120, 40);
  switch (op3) {
  case "Historial":
    op3X = 15;
    break;
  case "History":
    op3X = 22;
    break;
  }
  text(op3, op3X, 353, 140, 40);
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
      tab = 4;
    }
  } else {
    cursor(ARROW);
  }
  // Option 3
  if ((mouseX > -1) && (mouseX < 119) && (mouseY > 340) && (mouseY < 380)) {
    cursor(HAND);
    if (mousePressed) {
      tab = 3;
    }
  } else {
    cursor(ARROW);
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
  strokeWeight(2);
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
    rect(30, 65, 65, 60, 5, 10, 10, 10);
    strokeWeight(3);
    // UK Flag
    // Blue
    fill(69, 123, 157);
    rect(30, 65, 65, 30, 10, 10, 10, 10);
    // White
    strokeWeight(0);
    fill(241, 250, 238);
    rect(59, 67, 8, 26);
    rect(32, 77, 62, 7);
    stroke(241, 250, 238);
    strokeWeight(5);
    line(35, 70, 90, 90);
    line(35, 90, 90, 70);
    // Red
    strokeWeight(0);
    fill(230, 57, 70);
    rect(61, 67, 4, 26);
    rect(32, 79, 62, 3);
    stroke(230, 57, 70);
    strokeWeight(2);
    line(33, 69, 92, 91);
    line(33, 91, 92, 69);
    // Spain Flag
    // Red
    stroke(0);
    strokeWeight(2);
    fill(199, 3, 24);
    rect(30, 95, 65, 30, 10, 10, 10, 10);
    // Yellow
    strokeWeight(0);
    fill(252, 223, 0);
    rect(32, 104, 62, 12);
    // Border
    noFill();
    stroke(3);
    strokeWeight(2);
    rect(30, 30, 100, 30, 10, 5, 10, 5);
    strokeWeight(3);
    if (darkMode) {
      fill(229);
    } else {
      fill(50, 63, 121);
    }
    if ((mouseX > 30) && (mouseX < 105) && (mouseY > 65) && (mouseY < 95)) {
      textSize(16);
      text("English", 105, 85);
      if (mousePressed) {
        language = "EN";
      }
    } else {
      if ((mouseX > 30) && (mouseX < 105) && (mouseY > 95) && (mouseY < 125)) {
        text("Español", 105, 115);
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
  for (int i = 25; i <= 75; i+= 25) {
    ellipse(width / 2, width / 2, i, i);
  }
  line(width / 2, 300, width / 2, 420);
  line(300, width / 2, 420, width / 2);
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

// codigo tomado de "Mouse Arc Tangent", Processing starting project.
class Eye {
  int x, y;
  int size;
  float anglee = (float) 0.0;

  Eye(int tx, int ty, int ts) {
    x = tx;
    y = ty;
    size = ts;
  }

  void update(int mx, int my) {
    anglee = atan2(my - y, mx - x);
  }

  void display() {
    pushMatrix();
    translate(x, y);
    fill(255, 255, 147);
    ellipse(0, 0, size, size);
    rotate(anglee);
    fill(20);
    ellipse(size / 4, 0, size / 2, size / 2);
    popMatrix();
  }
}

// 1. Instructions
void infoPage() {
  image(inst, 0, 0);
}

// 2. Radar
void radarBg() {
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

void radar() {
  pushMatrix();
  translate(width/2, height-height*0.074);
  noFill();
  strokeWeight(1);
  stroke(255);
  arc(0, 0, (width-width*0.27), (width-width*0.27), PI, TWO_PI);
  arc(0, 0, (width-width*0.479), (width-width*0.479), PI, TWO_PI);
  arc(0, 0, (width-width*0.687), (width-width*0.687), PI, TWO_PI);
  line(-120, -120, -150, -150);
  line(120, -120, 150, -150);
  line(0, 0, (-width/2)*cos(radians(90)), (-width/2 + 22)*sin(radians(90)));
  strokeWeight(5);
  arc(0, 0, (width-width*0.0625), (width-width*0.0625), PI, TWO_PI);
  line(0, (-width/2 + 22)*sin(radians(90)), 0, (-width/2 + 60)*sin(radians(90)));
  line(-width/2 + 22, 0, width/2 - 22, 0);
  line(-218, -218, -238, -238);
  line(218, -218, 238, -238);
  line(0, 0, 0, -20);
  line(-20, 0, 20, 0);
  popMatrix();
}


void redLine() {
  pushMatrix();
  delay(0);
  translate(width/2,height-height*0.074);
  strokeWeight(10);
  stroke(255, 0, 0);
  dPixels = distanceInt*((height-height*0.1666)*0.025);
  if(distanceInt<30){
  line(dPixels*cos(radians(angleInt)),-dPixels*sin(radians(angleInt)),(width-width*0.535)*cos(radians(angleInt)),-(width-width*0.535)*sin(radians(angleInt)));
  }
  popMatrix();
}

void radarLine() {
  pushMatrix();
  strokeWeight(4);
  stroke(255);
  translate(width/2,height-height*0.074);
  line(0,0,(height-height*0.32)*cos(radians(angleInt)),-(height-height*0.32)*sin(radians(angleInt)));
  popMatrix();
}



// 3. Description
void descPanel() {
  image(desc, 0, 0);
}

// 4. History
void historyTable(String hisText) {
  strokeWeight(2);
  stroke(0);
  if (darkMode) {
    fill(229);
  } else {
    fill(50, 63, 121);
  }
  textSize(20);
  // Title
  switch (language) {
  case "ES":
    hisX = width/2 - 75;
    break;
  case "EN":
    hisX = width/2 - 70;
    break;
  }
  text(hisText, hisX, 65, 180, 50);
  // Table
  fill(229);
  rect(25, 100, 670, 150, 10, 10, 10, 10);
  for (int i = 167; i <= 620; i += 127) {
    strokeWeight(1);
    line(i, 100, i, 250);
  }
  line(25, 175, 695, 175);
  // Owl
  image(owl2, width/2 - 150, 260);
}

void hours() {
  fill(0);
  time[0][0] = "6:2:29";
  time[0][1] = "8:27:47";
  time[0][2] = "8:32:51";
  time[0][3] = "9:12:4";
  time[0][4] = "10:14:21";
  time[1][0] = "11:23:48";
  time[1][1] = "11:24:1";
  time[1][2] = "11:27:11";
  time[1][3] = "13:26:57";
  time[1][4] = "16:42:13";
  i = 0;
          j = 0;          
          for(int k = 130; k <= 205; k+=75) {
            for(int m = 60; m <= 585; m+=130) {
              //if(j != 0) {
                //if(time[i][j] != time[i][j - 1]) {
                  text(time[i][j], m, k, 120, 30);
                  j++;
                //}
              //}
     }
     i++;
     j = 0;
  }
}
void passwordBoard() {
  fill(229);
  stroke(50, 63, 121);
  rect(width - 150, 30, 115, 35, 10, 10, 10, 10);
  textSize(18);
  fill(50, 63, 121);
  switch (pText) {
  case "Password":
    pX = width - 133;
    break;
  case "Contraseña":
    pX = width - 138;
    break;
  }
  text(pText, pX, 42, 180, 30);
  if ((mouseX > width - 150) && (mouseX < width - 35) && (mouseY > 30) && (mouseY < 65) && (mousePressed)) {
    pb = true;
  } else if (!((mouseX > width - 150) && (mouseX < width - 35) && (mouseY > 30) && (mouseY < 230))) {
    cursor(ARROW);
    pb = false;
  }
  if (pb) {
    fill(229);
    // 1-3
    rect(width - 150, 70, 35, 35, 10, 10, 10, 10);
    rect(width - 110, 70, 35, 35, 10, 10, 10, 10);
    rect(width - 70, 70, 35, 35, 10, 10, 10, 10);
    //4-6
    rect(width - 150, 110, 35, 35, 10, 10, 10, 10);
    rect(width - 110, 110, 35, 35, 10, 10, 10, 10);
    rect(width - 70, 110, 35, 35, 10, 10, 10, 10);
    //7-0
    rect(width - 150, 150, 35, 35, 10, 10, 10, 10);
    rect(width - 110, 150, 35, 35, 10, 10, 10, 10);
    rect(width - 70, 150, 35, 35, 10, 10, 10, 10);
    rect(width - 110, 190, 35, 35, 10, 10, 10, 10);
    rect(width - 150, 30, 115, 35, 10, 10, 10, 10);
    fill(50, 63, 121);
    textSize(20);
    text("1", width - 139, 80, 35, 40);
    text("2", width - 99, 80, 35, 40);
    text("3", width - 59, 80, 35, 40);
    text("4", width - 139, 120, 35, 40);
    text("5", width - 99, 120, 35, 40);
    text("6", width - 59, 120, 35, 40);
    text("7", width - 139, 160, 35, 40);
    text("8", width - 99, 160, 35, 40);
    text("9", width - 59, 160, 35, 40);
    text("0", width - 99, 200, 35, 40);
    text(pass(num1) + pass(num2) + pass(num3) + pass(num4), width - 135, 55);
  }
}

void backButton(String backText) {
  // Back Button
  stroke(0);
  strokeWeight(2);
  fill(255, 203, 47);
  rect(30, 30, 85, 30, 10, 5, 10, 5);
  fill(0);
  textSize(16);
  switch (backText) {
  case "Atrás":
    backX = 52;
    break;
  case "Back":
    backX = 54;
    break;
  }
  text(backText, backX, 40, 70, 20);
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
