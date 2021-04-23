package study.step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 덧셈 계산기를 통한 TDD/리팩토링 실습")
public class StringAddCalculatorTest {

  @DisplayName("null 값을 입력할 경우 0을 반환해야 한다")
  @Test
  public void splitAndSum_null() {
    //given
    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    //when
    int result = stringAddCalculator.splitAndSum(null);

    //then
    assertThat(result).isEqualTo(0);
  }

  @DisplayName("빈문자 값을 입력할 경우 0을 반환")
  @Test
  public void splitAndSum_빈문자() {
    //given
    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    //when
    int result = stringAddCalculator.splitAndSum("");

    //then
    assertThat(result).isEqualTo(0);
  }

  @DisplayName("숫자 하나를 문자열로 입력할 경우 숫자를 반환")
  @Test
  public void splitAndSum_숫자하나() {
    //given
    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    //when
    int result = stringAddCalculator.splitAndSum("1");

    //then
    assertThat(result).isEqualTo(1);
  }

  @DisplayName("숫자 하나를 쉼표구문자와 함께 입력할 경우 숫자를 더한 값을 반환")
  @Test
  public void splitAndSum_쉼표구분자() {
    //given
    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    //when
    int result = stringAddCalculator.splitAndSum("1,2");

    assertThat(result).isEqualTo(3);
  }

  @DisplayName("숫자와 함께 쉼표 또는 콜론 구분자를 함께 입력 할 경우 숫자를 더한 값을 반환")
  @Test
  public void splitAndSum_쉼표_또는_콜론_구분자() {
    //given
    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    //when
    int result = stringAddCalculator.splitAndSum("1,2:3");

    //then
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("숫자와 함께 커스텀 구분자를 함께 입력 할 경우 숫자를 더한 값을 반환")
  @Test
  public void splitAndSum_custom_구분자() {
    //given
    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    //when
    int result = stringAddCalculator.splitAndSum("//;\n1;2;3");

    //then
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("음수를 입력 할 경우 Exception")
  @Test
  public void splitAndSum_negative() {
    //given
    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    //when
    Throwable thrown =  catchThrowable(() -> stringAddCalculator.splitAndSum("-1,2,3"));

    //then
    assertThat(thrown).isInstanceOf(RuntimeException.class);
  }



}
