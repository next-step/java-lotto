package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringParserTest {

  private Parser<String> parser;

  @BeforeEach
  void setUp() {
    parser = new StringParser();
  }

  @DisplayName("문자열 \"//;\n1;2;3\" 을 파싱하면 배열 [1, 2, 3] 을 반환한다")
  @Test
  void parse() {
    List<NationalNumber> actual = parser.parse("//;\n1;2;3");

    assertThat(actual).hasSize(3);
    assertThat(actual).containsExactly(
        new NationalNumber("1"),
        new NationalNumber("2"),
        new NationalNumber("3")
    );
  }

  @DisplayName("숫자 이외의 값 또는 음수를 파싱하면 예외가 발생한다")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,-1", "1,2,하"})
  void validate(String text) {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> parser.parse(text));
  }
}
