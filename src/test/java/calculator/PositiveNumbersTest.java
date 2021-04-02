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
    PositiveNumbers actual = PositiveNumbers.create(new Delimiter(",|:"), new NumberString(input));

    // then
    assertThat(actual)
            .isNotNull()
            .isEqualTo(new PositiveNumbers(Arrays.asList(new Number(1), new Number(2), new Number(3))));
  }

  @Test
  @DisplayName("양수 숫자 일급 컬렉션 객체 생성 - 커스텀 구분자")
  void create_customDelimiter() {
    // given
    String input = "//;\n1;2;3";

    // when
    PositiveNumbers actual = PositiveNumbers.create(Delimiter.createDelimiterRegexString(input), NumberString.generateNumberString(input));

    // then
    assertThat(actual)
            .isNotNull()
            .isEqualTo(new PositiveNumbers(Arrays.asList(new Number(1), new Number(2), new Number(3))));
  }
}