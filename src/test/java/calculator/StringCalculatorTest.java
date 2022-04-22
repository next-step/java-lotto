package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class StringCalculatorTest {

  private StringCalculator stringCalculator;

  @BeforeEach
  void init() {
    stringCalculator = new StringCalculator();
  }

  @Test
  @DisplayName("덧셈 테스트")
  void addTest() {
    assertThat(stringCalculator.calculate("1 + 1")).isEqualTo(2);
  }

  @Test
  @DisplayName("연산 횟수 3개 이상 테스트")
  void addTripleTest() {
    assertThat(stringCalculator.calculate("1 + 1 + 1 + 1")).isEqualTo(4);
  }

  @Test
  @DisplayName("뻴셈 테스트")
  void minasTest() {
    assertThat(stringCalculator.calculate("2 - 1")).isEqualTo(1);
  }

  @Test
  @DisplayName("곱셈 테스트")
  void multipleTest() {
    assertThat(stringCalculator.calculate("2 * 4")).isEqualTo(8);
  }

  @Test
  @DisplayName("나눗셈 테스트")
  void divTest() {
    assertThat(stringCalculator.calculate("4 / 2")).isEqualTo(2);
  }

  @Test
  @DisplayName("복합 테스트")
  void complexTest() {
    assertThat(stringCalculator.calculate("4 / 2 * 3")).isEqualTo(6);
  }

  @ParameterizedTest
  @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
  @NullAndEmptySource
  void blankCheckTest(String input) {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> {
          stringCalculator.calculate(input);
        }).withMessageMatching("null 또는 공백을 입력하실 수 없습니다.");
  }

  @Test
  @DisplayName("사칙연산 기호가 아닌 경우")
  void wrongSignTest() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> {
          stringCalculator.calculate("1 ^ 1");
        }).withMessageMatching("잘못된 부호를 넣었습니다. 다시 확인해주세요.");
  }

  @Test
  @DisplayName("숫자가 들어갈 자리에 숫자를 넣지 않는 경우")
  void wrongNumberTest() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> {
          stringCalculator.calculate("* + 1");
        }).withMessageMatching("For input string: \"\\S+\"");
  }

  @Test
  @DisplayName("0으로 나누는 경우")
  void zeroDivisionTest() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> {
          stringCalculator.calculate("1 / 0");
        }).withMessageMatching("/ by zero");
  }



}
