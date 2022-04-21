package calculator;

public class StringCalculator {

  public int calculate(String text) {
    String[] split = text.split("[+-/*//]");
    int result = Integer.parseInt(split[0].trim());
    for (int i = 1; i < split.length; i++) {
      if(text.contains("+")) {
        result += Integer.parseInt(split[i].trim());
      }
      if(text.contains("-")) {
        result -= Integer.parseInt(split[i].trim());
      }
      if(text.contains("*")) {
        result *= Integer.parseInt(split[i].trim());
      }
      if(text.contains("/")) {
        result /= Integer.parseInt(split[i].trim());
      }
    }
    return result;
  }
}
