package calculator;

public class StringCalculator {

  // "1 + 1 + 1 + 1"
  public int calculate(String text) {
    String[] split = text.split(" ");
    Number number = new Number(Integer.parseInt(split[0].trim()));
    for (int i = 1; i < split.length; i+=2) {
      if (split.length < i + 2) {
        continue;
      }
      number = number.calculate(split[i], Integer.parseInt(split[i + 1].trim()));
    }
    return number.getValue();
  }
}
