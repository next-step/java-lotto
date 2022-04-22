package calculator;

import calculator.enums.Sign;
import calculator.util.StringUtil;

public class StringCalculator {
  private static final int FIRST_KEY = 0;
  private static final int STEP = 2;
  private static final int START_INDEX = 1;
  private static final int NEXT_INDEX = 1;
  public int calculate(String text) {
    StringUtil.isBlank(text);
    String[] prepareData = StringUtil.split(text);
    Number resultNumber = new Number(StringUtil.parseInteger(prepareData[FIRST_KEY]));
    for (int i = START_INDEX; i < prepareData.length; i += STEP) {
      String operation = prepareData[i];
      int otherNumber = StringUtil.parseInteger(prepareData[i + NEXT_INDEX]);
      resultNumber = resultNumber.arithmetic(operation, otherNumber);
    }
    return resultNumber.getValue();
  }
}
