package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static base.MethodSourceConstant.CUSTOM_DELIMITER_ARGUMENTS;
import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {

  @ParameterizedTest
  @MethodSource(CUSTOM_DELIMITER_ARGUMENTS)
  @DisplayName("문자열을 split 할 정규식 문자열을 반환한다.")
  void getCustomDelimiter(String input, String expected) {
    // given

    // when
    Delimiter delimiter = Delimiter.createDelimiterRegexString(input);

    // then
    assertThat(delimiter)
            .isEqualTo(new Delimiter(expected));
  }

}