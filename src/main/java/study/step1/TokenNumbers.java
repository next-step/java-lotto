package study.step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TokenNumbers {

  private final String[] tokenNumber;

  public TokenNumbers(String[] tokenNumber) {
    this.tokenNumber = tokenNumber;
  }

  public List<Integer> convertNumbers() {
    return Arrays.stream(tokenNumber)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
