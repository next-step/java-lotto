package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Formula {

  private static final String DEFAULT_SEPARATOR = "[,:]";
  private static final String CUSTOM_SEPARATOR =  "//(.)\n(.*)";
  private static final String CONVERT_NULL_TO_ZERO = "0";

  private final List<Operand> operands;

  public Formula(List<Operand> operands) {
    this.operands = operands;
  }

  public static Formula createFormula(String userInput) {
    try {
      return defaultOrCustomSeparator(userInput);
    } catch (NullPointerException e) {
      return new Formula(byDefaultSeparator(CONVERT_NULL_TO_ZERO));
    }
  }

  private static Formula defaultOrCustomSeparator(String userInput) {
    if(isCustomSeparator(userInput)) {
      return new Formula(byCustomSeparator(userInput));
    }
    return new Formula(byDefaultSeparator(userInput));
  }

  private static List<Operand> byDefaultSeparator(String userInput) {
    String[] maybeOperand = userInput.split(DEFAULT_SEPARATOR);

    return Arrays.stream(maybeOperand)
        .map(Operand::new)
        .collect(Collectors.toList());
  }

  private static List<Operand> byCustomSeparator(String userInput) {
    Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(userInput);

    m.find();

    String customDelimiter = m.group(1);
    String[] maybeOperand = m.group(2).split(customDelimiter);

    return Arrays.stream(maybeOperand)
        .map(Operand::new)
        .collect(Collectors.toList());
  }

  private static boolean isCustomSeparator(String userInput) {
    return Pattern.compile(CUSTOM_SEPARATOR)
        .matcher(userInput)
        .find();
  }

  public int summation() {
    return operands.stream()
        .mapToInt(Operand::getOperand)
        .sum();
  }

  public List<Operand> getOperands() {
    return operands;
  }
}
