package stringaddcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringAddCalculatorTest {

  StringAddCalculator stringAddCalculator = null;

  @BeforeEach
  public void init() {
    this.stringAddCalculator = new StringAddCalculator();
  }

  @Test
  @DisplayName("계산기에 빈 문자열 입력할 경우 0을 반환 한다.")
  public void nullInputResultZero() {
    int result = stringAddCalculator.sumString("");
    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("계산기에 null을 입력할 경우 0을 반환 한다.")
  public void emptyInputResultZero() {
    int result = stringAddCalculator.sumString(null);
    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("숫자가 하나인 문자열은, 해당 값을 반환한다.")
  public void oneNumberNoSeparator() {
    int value = 3;
    int result = stringAddCalculator.sumString(String.valueOf(value));
    assertThat(result).isEqualTo(value);
  }

  @Test
  @DisplayName("구분자가 아닌 문자열이 온다면, RuntimeException 반환한다.")
  public void canOnlyHaveSeparatorCharacter() {
    String passedValue = "1:a:2";
    assertThatThrownBy(() -> stringAddCalculator.sumString(passedValue))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  @DisplayName("음수가 전달되면 RuntimeException을 반환한다.")
  public void canOnlyHavePositiveNumber() {
    String passedValue = "-1:1:2";
    assertThatThrownBy(() -> stringAddCalculator.sumString(passedValue))
        .isInstanceOf(RuntimeException.class);
  }

  @ParameterizedTest
  @DisplayName("구분자로 분리된 문자열을 더해 계산한다.")
  @MethodSource("generateDefaultSeparate")
  public void splitCommaAndColonAndSum(String expected, int sumNum) {
    int result = stringAddCalculator.sumString(expected);
    assertThat(result).isEqualTo(sumNum);
  }

  static Stream<Arguments> generateDefaultSeparate() {
    return Stream.of(
        Arguments.of("1,2:3", 6),
        genString_1_2_3("t"),
        genString_1_2_3("!"),
        genString_1_2_3(";"),
        genString_1_2_3("-")
    );
  }

  static Arguments genString_1_2_3(String delim) {
    return Arguments.of("//" + delim + "\n1"+delim+"2"+delim+"3", 6);
  }


}
