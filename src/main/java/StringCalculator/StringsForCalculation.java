package StringCalculator;

import static util.Validator.validateArgument;

import java.util.List;

public class StringsForCalculation {

  private static final String ERROR_MESSAGE_FOR_INVALID_LIST = "계산할 문자의 갯수가 너무 적습니다.";
  private static final int DISTANCE_TO_NEXT_OPERATOR = 2;
  private static final int MIN_LIST_SIZE = 3;
  private static final int INITIAL_CURSOR = 1;

  private final List<String> stringsForCalculation;


  StringsForCalculation(List<String> stringsForCalculation) {
    validate(stringsForCalculation);
    this.stringsForCalculation = stringsForCalculation;
  }

  public int calculate() {
    int cur = Integer.parseInt(stringsForCalculation.get(0));

    for (int cursor = INITIAL_CURSOR;
        cursor < stringsForCalculation.size();
        cursor += DISTANCE_TO_NEXT_OPERATOR) {
      int target = Integer.parseInt(stringsForCalculation.get(cursor + 1));
      cur = Operation.calculateBy(stringsForCalculation.get(cursor), cur, target);
    }

    return cur;
  }

  private void validate(List<String> list) {
    validateArgument(
        list,
        (arg) -> arg.size() >= MIN_LIST_SIZE && isOdd(arg.size()),
        ERROR_MESSAGE_FOR_INVALID_LIST
    );
  }

  private boolean isOdd(int number) {
    return number % 2 == 1;
  }
}
