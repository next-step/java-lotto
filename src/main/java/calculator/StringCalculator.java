package calculator;

public class StringCalculator {

  // "1 + 1 + 1 + 1"
  public int calculate(String text) {
    String[] split = text.split(" ");
    Number number = new Number(Integer.parseInt(split[0]));
    for (int i = 1; i < split.length; i+=2) {
      number = number.calculate(split[i], Integer.parseInt(split[i + 1]));
    }
    return number.getValue();
  }
}
