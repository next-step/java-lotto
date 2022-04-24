package StringCalculator;

import static util.Validator.validateArgument;

import java.util.List;

public class StringsForCalculation {

  private static final String ERROR_MESSAGE_FOR_INVALID_LIST = "계산할 문자의 갯수가 너무 적습니다.";
  private static final String ERROR_MESSAGE_FOR_INVALID_CURSOR = "커서의 위치가 적합하지 않습니다.";
  private static final int MIN_LIST_SIZE = 3;
  private static final int INITIAL_CURSOR = 1;

  private final List<String> stringsForCalculation;
  private int cursor;

  StringsForCalculation(List<String> list) {
    this(list, INITIAL_CURSOR);
  }

  StringsForCalculation(List<String> stringsForCalculation, int cursor) {
    validate(stringsForCalculation, cursor);
    this.stringsForCalculation = stringsForCalculation;
    this.cursor = cursor;
  }

  public int calculate() {
    int cur = Integer.parseInt(stringsForCalculation.get(0));
    do {
      int target = Integer.parseInt(stringsForCalculation.get(cursor + 1));
      cur = Operation.calculateBy(stringsForCalculation.get(cursor), cur, target);
      cursor += 2;
    } while (cursor < stringsForCalculation.size());
    return cur;
  }

  private void validate(List<String> list, int cursor) {
    validateArgument(
        list,
        (arg) -> arg.size() >= MIN_LIST_SIZE && isOdd(arg.size()),
        ERROR_MESSAGE_FOR_INVALID_LIST
    );
    validateArgument(
        cursor,
        (arg) -> arg == INITIAL_CURSOR,
        ERROR_MESSAGE_FOR_INVALID_CURSOR
    );
  }
  
  private boolean isOdd(int number) {
    return number % 2 == 1;
  }
}
