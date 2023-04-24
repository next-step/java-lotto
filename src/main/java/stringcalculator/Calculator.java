package stringcalculator;

public class Calculator {

  private static final String NUMBER_REGEX = "-?\\d+";

  private Input input;

  public Calculator(String input) {
    this(new Input(input));
  }

  private Calculator(Input input) {
    this.input = input;
  }

  public int calculate() {
    String[] inputArr = input.inputSplit();

    int number = getNumber(inputArr[0]);
    for (int i = 1; i < inputArr.length; i = i + 2) {
      String operator = inputArr[i];
      int nextNumber = getNumber(inputArr[i + 1]);
    }

    return 0;
  }

  private int getNumber(String input) {
    if (!input.matches(NUMBER_REGEX)) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
    return Integer.parseInt(input);
  }
}
