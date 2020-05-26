package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAdditionalCalculatorTest {

  @DisplayName("null 또는 빈문자 입력시 0 반환")
  @ParameterizedTest
  @MethodSource("provideNullOrEmptyString")
  public void splitAndSum_null_또는_빈문자(String text, int expected) {
    assertThat(StringAdditionalCalculator.splitAndSum(text)).isEqualTo(expected);
  }

  static Stream<Arguments> provideNullOrEmptyString () {
    return Stream.of(
      Arguments.of(null, 0),
      Arguments.of("", 0),
      Arguments.of("   ", 0)
    );
  }


  @DisplayName("숫자 토큰 하나를 입력 받을 경우, 그대로 반환한다.")
  @Test
  public void splitAndSum_숫자하나() throws Exception {
    int result = StringAdditionalCalculator.splitAndSum("1");
    assertThat(result).isEqualTo(1);
  }

  @DisplayName("쉼표 구분자로 잘 작동 되는지 확인한다.")
  @Test
  public void splitAndSum_쉼표구분자() throws Exception {
    int result = StringAdditionalCalculator.splitAndSum("1,2");
    assertThat(result).isEqualTo(3);
  }

  @DisplayName("쉼표 혹은 콜론 구분자로 잘 작동 되는지 확인한다.")
  @Test
  public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
    int result = StringAdditionalCalculator.splitAndSum("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("커스텀 구분자로 잘 작동 되는지 확인한다.")
  @Test
  public void splitAndSum_custom_구분자() throws Exception {
    int result = StringAdditionalCalculator.splitAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("음수 혹은 숫자가 아닌 경우에 Throw를 발생시킨다")
  @ParameterizedTest
  @ValueSource(strings = { "-1,2,3", "test,1234,ada", "$!ASDasfa" })
  public void splitAndSum_negative(String text) throws Exception {
    assertThatThrownBy(() -> StringAdditionalCalculator.splitAndSum(text))
      .isInstanceOf(RuntimeException.class);
  }

}
