package lotto.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateStringToIntNumber implements GenerateValues{

  private final String values;

  public GenerateStringToIntNumber(final String manualLottosNumbers) {
    values = manualLottosNumbers;
  }

  @Override
  public List<Integer> createNumberPull() {
    return Arrays.stream(values.trim().split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}