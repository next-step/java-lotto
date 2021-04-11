package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PositiveNumbersTest {

  @Test
  @DisplayName("양수 숫자 일급 컬렉션 객체 생성")
  void create() {
    // given
    String input = "1,2:3";

    // when
    PositiveNumbers actual = PositiveNumbers.generate(Delimiter.create(",|:"), NumberString.create(input));

    // then
    assertThat(actual)
            .isNotNull()
            .isEqualTo(PositiveNumbers.create(Arrays.asList(Number.create(1), Number.create(2), Number.create(3))));
  }

  @Test
  @DisplayName("양수 숫자 일급 컬렉션 객체 생성 - 커스텀 구분자")
  void create_customDelimiter() {
    // given
    String input = "//;\n1;2;3";

    // when
    PositiveNumbers actual = PositiveNumbers.generate(Delimiter.createDelimiterRegexString(input), NumberString.generateNumberString(input));

    // then
    assertThat(actual)
            .isNotNull()
            .isEqualTo(PositiveNumbers.create(Arrays.asList(Number.create(1), Number.create(2), Number.create(3))));
  }
}