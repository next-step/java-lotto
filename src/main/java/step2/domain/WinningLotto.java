package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

  private static final String SPLIT_FLAG = ",";
  private static final int LOTTO_NUMBER_LIMIT_SIZE = 6;

  private final List<Number> numbers;

  public WinningLotto(String input) {
    this.numbers = init(input);
  }

  private List<Number> init(String input) {
    List<Number> numbers = Arrays.stream(input.split(SPLIT_FLAG))
        .map(Number::new)
        .collect(Collectors.toList());
    validate(numbers);
    return numbers;
  }

  public List<Number> getNumbers() {
    return this.numbers;
  }

  private void validate(List<Number> numbers) {
    if (numbers.size() != LOTTO_NUMBER_LIMIT_SIZE) {
      throw new IllegalArgumentException();
    }
  }
}
