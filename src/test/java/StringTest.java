import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

  @Test
  void givenNumbersWithDelimiter_whenSplitByDelimiter_thenGetSplitNumbers() {
    // Given
    String numbersWithDelimiter = "1,2";
    String delimiter = ",";

    // When
    String[] splitNumbers = numbersWithDelimiter.split(delimiter);

    // Then
    assertThat(splitNumbers).containsExactly("1", "2");
  }

  @Test
  void givenNumber_whenSplitByDelimiter_thenGetOnlyNumber() {
    // Given
    String number = "1";
    String delimiter = ",";

    // When
    String[] splitNumber = number.split(delimiter);

    // Then
    assertThat(splitNumber).containsExactly("1");
  }
}
