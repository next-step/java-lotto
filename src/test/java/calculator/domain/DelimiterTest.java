package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterTest {

  @Test
  @DisplayName("Test split with default delimiter.")
  public void testDefaultDelimiter() {
    Delimiter defaultDelimiter = Delimiter.from(null);

    String[] splitWithComma = defaultDelimiter.split("123,4");
    String[] splitWithColon = defaultDelimiter.split("123:4");

    assertArrayEquals(splitWithComma, new String[]{"123", "4"});
    assertArrayEquals(splitWithColon, new String[]{"123", "4"});
  }

  @Test
  @DisplayName("Test split with custom delimiter.")
  public void testCustomDelimiter() {
    Delimiter customDelimiter = Delimiter.from("?");

    String[] splitWithCustomDelimiter = customDelimiter.split("1?2?3");

    assertArrayEquals(splitWithCustomDelimiter, new String[]{"1", "2", "3"});
  }

  @Test
  @DisplayName("Test split with empty delimiter. (The empty string can be delimiter.)")
  public void testEmptyDelimiter() {
    Delimiter emptyDelimiter = Delimiter.from("");

    String[] splitWithEmpty = emptyDelimiter.split("123");

    assertArrayEquals(splitWithEmpty, new String[]{"1", "2", "3"});
  }
}
