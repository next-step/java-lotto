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

    Numbers numbers = new Numbers(convertedNumbers);

    numbers.validatorNumbers();

    return numbers.sum();
  }

  public List<Integer> convertNumbers(String[] tokenNumber) {
    return Arrays.stream(tokenNumber)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

}
