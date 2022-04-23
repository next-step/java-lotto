package StringCalculator;

import util.Validator;

public class StringCalculator {

  private static final String ERROR_MESSAGE_FOR_INVALID_INPUT = "올바른 텍스트를 입력해주세요.";
  private static final String INPUT_DELIMITER = " ";


  private final String input;

  private StringCalculator(String input) {
    validate(input);
    this.input = input;
  }

//  public static StringCalculator init(String input) {
//    StringCalculator stringCalculator = new StringCalculator(input);
//    String[] values = input.split(INPUT_DELIMITER);
//  }

  protected void validate(String input) {
    Validator.validateArgument(
        input,
        (arg) -> !input.isEmpty() && !input.isBlank(),
        ERROR_MESSAGE_FOR_INVALID_INPUT
    );
  }
}
