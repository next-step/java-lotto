package calculator;

import calculator.enums.Sign;
import calculator.util.StringUtil;

public class StringCalculator {

  public int calculate(String text) {
    if(text == null || text.isBlank()) throw new IllegalArgumentException("null");
    String[] split = StringUtil.split(text);
    Number number = new Number(getOpponentValue(split[0]));
    for (int i = 1; i < split.length; i += 2) {
      number = number.calculate(getOpponentValue(split[i + 1]), split[i]);
    }
    return number.getValue();
  }

  private int getOpponentValue(String opponent) {
    return Integer.parseInt(opponent);
  }
}
