package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NonNegativeTokens {
  private static final String EMPTY_STRING = "";

  private List<NonNegativeInt> integers;

  public NonNegativeTokens(String expression, String delimiter) {
    if (expression == null || expression.equals(EMPTY_STRING)) {
      integers = new ArrayList<>(Arrays.asList(new NonNegativeInt(0)));
      return;
    }

    integers = Arrays.stream(expression.split(delimiter))
        .map(Integer::parseInt)
        .map(NonNegativeInt::new)
        .collect(Collectors.toList());
  }

  public Integer sum() {
    return integers.stream()
        .map(NonNegativeInt::getInteger)
        .mapToInt(Integer::intValue)
        .sum();
  }
}
