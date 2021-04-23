package study.step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {

  public StringAddCalculator() {
  }

  public int splitAndSum(String text) {
    if (Validator.isEmpty(text)) {
      return 0;
    }

    TokenDelimiter tokenDelimiter = new TokenDelimiter(text);

    List<Integer> convertedNumbers = convertNumbers(tokenDelimiter.getNumberTokens());

    PositiveNumbers positiveNumbers = new PositiveNumbers(convertedNumbers);

    positiveNumbers.validatorNumbers();

    return positiveNumbers.sum();
  }

  public List<Integer> convertNumbers(String[] tokenNumber) {
    return Arrays.stream(tokenNumber)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

}
