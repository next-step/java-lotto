package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Tokens {

  String[] tokens;

  public Tokens(String[] tokens) throws Exception {
    this.tokens = tokens;
    validate();
  }

  private void validate() throws Exception {
    for (String token : tokens) {
      checkNatureNumber(token);
    }
  }

  private void checkNatureNumber(String token) throws Exception {
    if (!Pattern.matches("^[0-9]*$", token)) {
      throw new RuntimeException("자연수만 들어올수 있습니다.");
    }
  }

  public int sum() {
    return Arrays.stream(tokens)
        .mapToInt(Integer::parseInt)
        .sum();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tokens tokens1 = (Tokens) o;
    return Arrays.equals(tokens, tokens1.tokens);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(tokens);
  }
}
