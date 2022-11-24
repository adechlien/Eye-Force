// Arduino
void serialEvent (Serial myPort) {// recibe los datos del puerto

  if (myPort!= null) {

    port = myPort.readStringUntil('.');  // los lee solo hasta el punto, ya que es lo que se necesita (angulo y distancia)
    println(port);
    
    if (port != null) {
      port = port.substring(0, port.length()-1);
      println(port);
      if (port != null) {
        println(port);
        index = port.indexOf(",");// se guarda la posición de la coma, que es el caracter que separa al angulo y la distancia
        angle= port.substring(0, index); // lee desde el inicio hasta un lugar antes de la coma, es decir, el ángulo
        distance= port.substring(index + 1, port.length());// lee desde un caracter despues de la coma y hasta el final, es decir, la distancia en cm
        angleInt = int(angle); // conversion de string a entero
        distanceInt = int(distance);
        if (distanceInt < 30) {
          player.play();                 
          time[i][j] = hour() + ":" + minute() + ":" + second();
          j = j +1;
          if (j == 9) {
            j = 0;
            i = i +1;
          }
          if (i == 2) {
            i = 0;
          }
        }
      }
    }         
  }
}
