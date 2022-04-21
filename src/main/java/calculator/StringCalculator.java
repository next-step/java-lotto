package calculator;

public class StringCalculator {

  public int calculate(String text) {
    String[] split = text.split("[+]");
    return Integer.parseInt(split[0].trim()) + Integer.parseInt(split[1].trim());
  }
}
