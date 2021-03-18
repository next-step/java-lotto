package calculator;

public class Number {

  private int number;

  public Number(String token) {
    this.number = stringToInt(token);
  }

  private int stringToInt(String token) {
    int number = 0;
    try {
      number = Integer.parseInt(token);
    } catch (RuntimeException e) {
      throw new InvalidNumException();
    }
    return isNegativeNum(number);
  }

  private int isNegativeNum(int number) {
    if (number < Constant.ZERO) {
      throw new InvalidNumException();
    }
    return number;
  }

  public int getNumber() {
    return this.number;
  }
}
