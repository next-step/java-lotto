package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operand {
  private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
  private static final String ILLEGAL_NUMBER_MESSAGE = "양수를 입력해주세요.";
  private final String operand;

  public Operand(String operand) {
    this.operand = validatedOperand(operand);
  }

  public int number() {
    return Integer.parseInt(operand);
  }

  private String validatedOperand(String operand) {
    if (!isOperand(operand)) {
      throw new IllegalArgumentException(ILLEGAL_NUMBER_MESSAGE);
    }

    return operand;
  }

  private boolean isOperand(String operand) {
    Matcher operandMatcher = NUMBER_PATTERN.matcher(operand);

    return operandMatcher.find();
  }
}
