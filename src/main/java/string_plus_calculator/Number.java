package string_plus_calculator;

public class Number {

  private int number;

  private Number() { }

  public static Number from(String numberString) {
    Number number = new Number();
    int parseNumber = Integer.parseInt(numberString);
    checkMinus(parseNumber);
    number.number = parseNumber;
    return number;
  }

  private static void checkMinus(int number) {
    if (number < 0) {
      throw new RuntimeException("minus number is invalid.");
    }
  }

  public int plus(int result) {
    return this.number + result;
  }
}
