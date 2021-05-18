import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

  @Test
  void givenNumbersWithParentheses_whenSubstring_thenGetNumbersWithoutParentheses() {
    // Given
    String numbersWithParentheses = "(1,2)";

    // When
    String numbers = numbersWithParentheses.substring(1, numbersWithParentheses.length() - 1);

    // Then
    assertEquals("1,2", numbers);
  }

  @Test
  @DisplayName("String 의 특정 위치 문자를 가져옴")
  void givenCharacters_whenCharAt_thenGetOneCharacter() {
    // Given
    String abc = "abc";

    // When
    char c = abc.charAt(0);

    // Then
    assertEquals('a', c);
  }

  @Test
  @DisplayName("String 의 index 범위 밖 특정 위치 문자를 가져오려고 할 경우, StringIndexOutOfBoundsException 발생")
  void givenCharacters_whenCharAtOutOfBounds_thenThrowStringIndexOutOfBoundsException() {
    // Given
    String alphabets = "abc";
    int indexOutOfBounds = 3;

    // When, Then
    assertThatThrownBy(() -> alphabets.charAt(indexOutOfBounds))
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: " + indexOutOfBounds);
  }
}
