package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import step1.controller.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
  @ParameterizedTest
  @EmptySource
  public void splitAndSum_null_또는_빈문자(String expression) {
    int result = StringAddCalculator.splitAndSum(expression);
    assertThat(result).isEqualTo(0);
  }

  @Test
  public void splitAndSum_숫자하나() throws Exception {
    int result = StringAddCalculator.splitAndSum("1");
    assertThat(result).isEqualTo(1);
  }

  @Test
  public void splitAndSum_문자하나() throws Exception {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a"))
      .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void splitAndSum_쉼표구분자() throws Exception {
    int result = StringAddCalculator.splitAndSum("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
    int result = StringAddCalculator.splitAndSum("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  public void splitAndSum_custom_구분자() throws Exception {
    int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  public void splitAndSum_negative() throws Exception {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
      .isInstanceOf(RuntimeException.class);
  }
}