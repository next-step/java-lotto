package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

  @Test
  public void EmptyInputTest() {
    assertThat(Calculator.splitAndSum(null)).isEqualTo(0);
    assertThat(Calculator.splitAndSum("")).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(strings = {"-1", "2:-1", "1,-1:3"})
  public void ZeroContainingFormulaTest(String expression) {
    assertThatThrownBy(() -> Calculator.splitAndSum(expression))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("NonNegativeInt can't be negative integer");
  }

  @ParameterizedTest
  @ValueSource(strings = {"abc", "//\n", "!@#$", "1:2:3::4", "1;:2"})
  public void NaNFormulaTest(String expression) {
    assertThatThrownBy(() -> Calculator.splitAndSum(expression))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"0,1,2=3", "1:2=3", "1,2:3=6", "1,2,3,4=10"}, delimiter = '=')
  public void defaultDelimiterTest(String expression, String expectedValue) {
    assertThat(Calculator.splitAndSum(expression)).isEqualTo(Integer.parseInt(expectedValue));
  }

  @Test
  public void customDelimiterTest() {
    assertThat(Calculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    assertThat(Calculator.splitAndSum("//+\n1+2+3+4")).isEqualTo(10);
  }

  @ParameterizedTest
  @ValueSource(strings = {"//;\n1,2", "//;\n1;2:3", "//;\n1;2+3;4"})
  public void illegalCustomDelimiterTest(String expression) {
    assertThatThrownBy(() -> Calculator.splitAndSum(expression))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
