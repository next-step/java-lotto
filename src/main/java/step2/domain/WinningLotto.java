package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
  List<Number> numbers;

  public WinningLotto(String input) {
    this.numbers = init(input);
  }

  private List<Number> init(String input) {
    return Arrays.stream(input.split(","))
        .map(Number::new)
        .collect(Collectors.toList());
  }
}
