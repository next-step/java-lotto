package calculator;

import calculator.domain.NumbersAndOperatorsGroup;
import calculator.domain.Operator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class TokenParserTest {

  @ParameterizedTest(name = "[{index}] \"{0}\" → numbers: {1}, operators: {2}")
  @CsvSource({
          "'1 + 2', '1:2', '+:'",
          "'3 - 1 + 4', '3:1:4', '-:+'",
          "'10 * 2 / 5', '10:2:5', '*:/'"
  })
  void parse_shouldSplitInputIntoNumbersAndOperators(String input, String expectedNums, String expectedOps) {
    List<Integer> expectedNumbers = parseNumbers(expectedNums);
    List<Operator> expectedOperators = parseOperators(expectedOps);

    NumbersAndOperatorsGroup result = TokenParser.parse(input);

    assertThat(result.getNumbers()).isEqualTo(expectedNumbers);
    assertThat(result.getOperators()).isEqualTo(expectedOperators);
  }

  private List<Integer> parseNumbers(String colonSeparated) {
    if (colonSeparated.isEmpty()) return List.of();
    String[] tokens = colonSeparated.split(":");
    return java.util.Arrays.stream(tokens)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
  }

  private List<Operator> parseOperators(String colonSeparated) {
    if (colonSeparated.isEmpty()) return List.of();
    String[] tokens = colonSeparated.split(":");
    return java.util.Arrays.stream(tokens)
            .map(Operator::from)
            .collect(Collectors.toList());
  }
}
