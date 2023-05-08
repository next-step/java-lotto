package study.calculator;

public class Calculator {

  private final static String ARITHMETIC_OPERATOR = "[\\d\\+\\-\\*/\\s]+";
  private final static String NUMBERS_OPERATOR = "\\d+";


  public String run(Input input) {
    String value = input.getValue();
    this.validate(value);
    String[] splitInput = value.split(" ");
    return this.calculate(splitInput);
  }

  private String calculate(String[] splitInput) {
    int result = Integer.parseInt(splitInput[0]);

    for (int i = 1; i < splitInput.length; i += 2) {
      result = this.evaluateExpression(result, splitInput[i], splitInput[i + 1]);
    }

    return String.valueOf(result);
  }

  private int evaluateExpression(int num1, String operator, String num2) {
    int num2Int = Integer.parseInt(num2);
    switch(operator) {
      case "*":
        return num1 * num2Int;
      case "/":
        return num1 / num2Int;
      case "+":
        return num1 + num2Int;
      case "-":
        return num1 - num2Int;
    }

    throw new IllegalArgumentException("유효하지 않은 operator 입니다.");
  }

  private void validate(String str) {
    if(str == null) {
      throw new IllegalArgumentException("null 값 안된다.");
    }

    if(str.split(" ").length < 3) {
      throw new IllegalArgumentException("빈 공백 문자여서는 안된다.");
    }

    if (!this.isRightStr(str)) {
      throw new IllegalArgumentException("옳바른 입려값 아니다.");
    }

    String firstSplit = str.split(" ")[0];

    if (!this.isNumber(firstSplit)) {
      throw new IllegalArgumentException("첫 번째 문자는 숫자다.");
    }
  }

  private boolean isRightStr(String str) {
    return str.matches(ARITHMETIC_OPERATOR);
  }

  private boolean isNumber(String str) {
    return str.matches(NUMBERS_OPERATOR);
  }
}
