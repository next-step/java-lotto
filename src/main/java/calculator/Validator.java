package calculator;

import java.util.regex.Pattern;

public class Validator {

  public static void validate(String[] input) throws Exception {
    for (String token : input) {
      checkNatureNumber(token);
    }
  }

  private static void checkNatureNumber(String token) throws Exception {
    if (!Pattern.matches("^[0-9]*$", token)) {
      throw new RuntimeException("자연수만 들어올수 있습니다.");
    }
  }
}
