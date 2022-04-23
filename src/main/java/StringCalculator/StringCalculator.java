package StringCalculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import util.Validator;

public class StringCalculator {

  private static final String ERROR_MESSAGE_FOR_INVALID_INPUT = "올바른 텍스트를 입력해주세요.";
  private static final String INPUT_DELIMITER = " ";

  private final StringsForCalculation values;

  private StringCalculator(List<String> stringList) {
    this(new StringsForCalculation(stringList));
  }

  private StringCalculator(StringsForCalculation values) {
    this.values = values;
  }

  public static StringCalculator init(String input) {
    validate(input);
    String[] values = input.split(INPUT_DELIMITER);
    return new StringCalculator(Stream.of(values)
        .collect(Collectors.toUnmodifiableList()));
  }

  public int run() {
    Objects.requireNonNull(values);
    return values.calculate();
  }

  private static void validate(String input) {
    Validator.validateArgument(
        input,
        (arg) -> !input.isEmpty() && !input.isBlank(),
        ERROR_MESSAGE_FOR_INVALID_INPUT
    );
  }
}
