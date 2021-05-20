package calculator;

import calculator.InputValidator;
import calculator.NumberAdder;
import calculator.StringAddCalculator;
import calculator.StringSplitter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

  @Test
  void givenEmptyString() {
    // Given
    String delimiterRegex = ",|:";
    String customDelimiterRegex = "//(.)\n(.*)";
    String input = "";

    StringAddCalculator stringAddCalculator = getStringAddCalculator(delimiterRegex, customDelimiterRegex);

    // When
    int result = stringAddCalculator.calculate(input);

    // Then
    assertEquals(0, result);
  }

  @Test
  void givenNull() {
    // Given
    String delimiterRegex = ",|:";
    String customDelimiterRegex = "//(.)\n(.*)";
    String input = null;

    StringAddCalculator stringAddCalculator = getStringAddCalculator(delimiterRegex, customDelimiterRegex);

    // When
    int result = stringAddCalculator.calculate(input);

    // Then
    assertEquals(0, result);
  }

  @Test
  void givenSingleNumber() {
    // Given
    String delimiterRegex = ",|:";
    String customDelimiterRegex = "//(.)\n(.*)";
    String input = "1";

    StringAddCalculator stringAddCalculator = getStringAddCalculator(delimiterRegex, customDelimiterRegex);

    // When
    int result = stringAddCalculator.calculate(input);

    // Then
    assertEquals(1, result);
  }

  @Test
  void givenCommaDelimiter() {
    // Given
    String delimiterRegex = ",|:";
    String customDelimiterRegex = "//(.)\n(.*)";
    String input = "1,2";

    StringAddCalculator stringAddCalculator = getStringAddCalculator(delimiterRegex, customDelimiterRegex);

    // When
    int result = stringAddCalculator.calculate(input);

    // Then
    assertEquals(3, result);
  }

  @Test
  void givenCommaAndColonDelimiter() {
    // Given
    String delimiterRegex = ",|:";
    String customDelimiterRegex = "//(.)\n(.*)";
    String input = "1,2:3";

    StringAddCalculator stringAddCalculator = getStringAddCalculator(delimiterRegex, customDelimiterRegex);

    // When
    int result = stringAddCalculator.calculate(input);

    // Then
    assertEquals(6, result);
  }

  @Test
  void givenCustomDelimiter() {
    // Given
    String delimiterRegex = ",|:";
    String customDelimiterRegex = "//(.)\n(.*)";
    String input = "//;\n1;2;3";

    StringAddCalculator stringAddCalculator = getStringAddCalculator(delimiterRegex, customDelimiterRegex);

    // When
    int result = stringAddCalculator.calculate(input);

    // Then
    assertEquals(6, result);
  }

  @Test
  void givenNotNumber() {
    // Given
    String delimiterRegex = ",|:";
    String customDelimiterRegex = "//(.)\\n(.*)";
    String input = "abc";

    StringAddCalculator stringAddCalculator = getStringAddCalculator(delimiterRegex, customDelimiterRegex);

    // When, Then
    assertThatThrownBy(() -> stringAddCalculator.calculate(input))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void givenNegativeNumber() {
    // Given
    String delimiterRegex = ",|:";
    String customDelimiterRegex = "//(.)\\n(.*)";
    String input = "-1,2,3";

    StringAddCalculator stringAddCalculator = getStringAddCalculator(delimiterRegex, customDelimiterRegex);

    // When, Then
    assertThatThrownBy(() -> stringAddCalculator.calculate(input))
        .isInstanceOf(RuntimeException.class);
  }

  private StringAddCalculator getStringAddCalculator(String delimiterRegex, String customDelimiterRegex) {
    return new StringAddCalculator(
        new StringSplitter(delimiterRegex, customDelimiterRegex),
        new InputValidator(),
        new NumberAdder()
    );
  }
}
