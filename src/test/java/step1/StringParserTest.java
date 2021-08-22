package step1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringParserTest {

  private Parser<String> parser;

  @BeforeEach
  void setUp() {
    parser = new StringParser();
  }

  @DisplayName("문자열 \"//;\n1;2;3\" 을 파싱하면 NationalNumbers 의 사이즈는 3이다")
  @Test
  void parse() {
    NationalNumbers actual = parser.parse("//;\n1;2;3");

    assertThat(actual.size()).isEqualTo(3);
  }

}
