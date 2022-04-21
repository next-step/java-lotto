package calculator;

import calculator.util.StringUtil;

public class StringCalculator {

  // "1 + 1 + 1 + 1"
  public int calculate(String text) {
    String[] split = StringUtil.split(text);
    Number number = new Number(Integer.parseInt(split[0]));
    for (int i = 1; i < split.length; i+=2) {
      number = number.calculate(split[i], getOpponentValue(split[i + 1]));
    }
    return number.getValue();
  }

  private int getOpponentValue(String opponent) {
    return Integer.parseInt(opponent);
  }
}
