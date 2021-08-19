package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

  @Test
  @DisplayName("null, 공백 문자열 처리 테스트")
  public void splitAndSum_null_또는_빈문자() {
    int result = StringAddCalculator.splitAndSum(null);
    assertThat(result).isEqualTo(0);

    result = StringAddCalculator.splitAndSum("");
    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("숫자 하나만 있을때 테스트")
  public void splitAndSum_숫자하나() throws Exception {
    int result = StringAddCalculator.splitAndSum("1");
    assertThat(result).isEqualTo(1);
  }

  @Test
  @DisplayName("기본구분자(쉼표만) 테스트")
  public void splitAndSum_쉼표구분자() throws Exception {
    int result = StringAddCalculator.splitAndSum("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  @DisplayName("기본구분자(쉼표,콜론 둘다) 테스트")
  public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
    int result = StringAddCalculator.splitAndSum("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  @DisplayName("커스텀 구분자 테스트")
  public void splitAndSum_custom_구분자() throws Exception {
    int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  @DisplayName("음수값 테스트")
  public void splitAndSum_negative() throws Exception {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }
}
