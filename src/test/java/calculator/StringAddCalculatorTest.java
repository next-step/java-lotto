package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

  private StringAddCalculator stringAddCalculator;

  @BeforeEach
  void setUp() {
    stringAddCalculator = new StringAddCalculator();
  }

  @Test
  @DisplayName("[StringAddCalculator] null 또는 빈문자 입력에 대한 테스트")
  public void splitAndSum_null_또는_빈문자() {
    String input = null;

    int result = stringAddCalculator.splitAndSum(input);

    assertThat(result).isEqualTo(0);

    input = "";

    result = stringAddCalculator.splitAndSum(input);

    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("[StringAddCalculator] 숫자 하나를 입력했을 경우에 대한 테스트")
  public void splitAndSum_숫자하나() throws Exception {
    String input = "1";

    int result = stringAddCalculator.splitAndSum(input);

    assertThat(result).isEqualTo(1);
  }

  @Test
  @DisplayName("[StringAddCalculator] 쉼표 구분자로 숫자 두개를 입력했을 경우에 대한 테스트")
  public void splitAndSum_쉼표구분자() throws Exception {
    String input = "1,2";

    int result = stringAddCalculator.splitAndSum(input);

    assertThat(result).isEqualTo(3);
  }

  @Test
  @DisplayName("[StringAddCalculator] 쉼표/콜론 구분자를 사용했을 경우에 대한 테스트")
  public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
    String input = "1,2:3";

    int result = stringAddCalculator.splitAndSum(input);

    assertThat(result).isEqualTo(6);
  }

  @Test
  @DisplayName("[StringAddCalculator] 커스텀 구분자를 사용했을 경우에 대한 테스트")
  public void splitAndSum_custom_구분자() throws Exception {
    String input = "//;\n1;2;3";

    int result = stringAddCalculator.splitAndSum(input);

    assertThat(result).isEqualTo(6);
  }

  @Test
  @DisplayName("[StringAddCalculator] 음수를 입력했을 경우 예외처리 테스트")
  public void splitAndSum_negative() throws Exception {
    assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }
}
