package calculator;

public class DefaultSeparator {

  private static final String STRING_CALCULATOR_DELIIMITER = ",|:";

  public static Tokens separate(String input) throws Exception {
    return new Tokens(input.split(STRING_CALCULATOR_DELIIMITER));
  }
}
