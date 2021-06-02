package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumberGenerator implements NumberGenerator {

  private final String inputManualNumber;

  public ManualNumberGenerator(String inputManualNumber) {
    this.inputManualNumber = inputManualNumber;
  }

  @Override
  public List<Integer> generateNumbers() {
    return Arrays.stream(this.inputManualNumber.trim().replace(" ", "").split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
