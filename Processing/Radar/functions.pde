int getNumberEntered() {
  switch(key) {
  case '0':
    return 0;
  case '1':
    return 1;

  case '2':
    return 2;

  case '3':
    return 3;

  case '4':
    return 4;

  case '5':
    return 5;

  case '6':
    return 6;

  case '7':
    return 7;

  case '8':
    return 8;

  case '9':
    return 9;

  default:
    return -1;
  }
}

String pass(int number) {
  if (number == -1) return "*";
  else return str(number);
}

String concatPass(int num1, int num2, int num3, int num4) {
  return str(num1) + str(num2) + str(num3) + str(num4);
}
