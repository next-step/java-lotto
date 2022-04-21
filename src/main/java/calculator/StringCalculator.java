package calculator;

public class StringCalculator {

  public int calculate(String text) {
    String[] split = text.split("[+]");
    int result = 0;
    for (String str : split) {
      result += Integer.parseInt(str.trim());
    }
    return result;
  }
}
