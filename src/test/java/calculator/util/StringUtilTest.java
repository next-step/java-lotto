package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static base.MethodSourceConstant.CUSTOM_DELIMITER_ARGUMENTS;
import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("빈 문자열 또는 null일 경우 true를 반환한다.")
  void isBlank(String blankString) {
    // given

    // when
    boolean actual = StringUtil.isBlank(blankString);

    // then
    assertThat(actual).isTrue();
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("빈 문자열 또는 null일 경우 \"\" 문자열을 반환한다.")
  void defaultBlankString(String blankString) {
    // given

    // when
    String actual = StringUtil.defaultBlankString(blankString);

    // then
    assertThat(actual).isEqualTo("");
  }

  @ParameterizedTest
  @MethodSource(CUSTOM_DELIMITER_ARGUMENTS)
  @DisplayName("특정 문자열을 포함하는지 확인한다.")
  void find(String str, String delimiter, boolean expected) {
    // given

    // when
    boolean find = StringUtil.find(str, "//(.)\n(.*)");

    // then
    assertThat(find).isEqualTo(expected);
  }

  @Test
  @DisplayName("정규식 그룹에 해당되는 문자열을 반환한다.")
  void findGroup() {
    // given
    final String regex = "//(.)\n(.*)";
    final String input = "//,\n1,2,3";

    // when
    String actual = StringUtil.findGroup(input, regex, 2);

    // then
    assertThat(actual).isEqualTo("1,2,3");
  }
}