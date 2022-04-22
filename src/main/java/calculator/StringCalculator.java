package calculator;

import calculator.enums.Sign;
import calculator.util.StringUtil;

public class StringCalculator {

  public int calculate(String text) {
    if (text == null || text.isBlank()) {
      throw new IllegalArgumentException("null");
    }
    String[] prepareData = StringUtil.split(text);
    Number number = new Number(StringUtil.parseInteger(prepareData[0]));
    for (int i = 1; i < prepareData.length; i += 2) {
      number = number.arithmetic(prepareData[i], StringUtil.parseInteger(prepareData[i + 1]));
    }
    return number.getValue();
  }
}
