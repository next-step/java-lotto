package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringAddCalculatorTest {

  @Test
  @DisplayName("올바르지 않는 input(null)")
  public void WithNullString() {
    int result = StringAddCalculator.splitAndSum(null);
    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("올바르지 않는 input(empty)")
  public void WithEmptyString() {
    int result = StringAddCalculator.splitAndSum("");
    assertThat(result).isEqualTo(0);
  }

  @ParameterizedTest
  @CsvSource(value = {"0:0", "1:1", "10:10"}, delimiter = ':')
  @DisplayName("단일 항에서의 값 반환")
  public void SingleValue(String input, int expected) {
    int result = StringAddCalculator.splitAndSum(input);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(
      value = {"0,0:0", "0,1:1", "1,0:1", // 1자릿수 엣지 케이스
          "3,3:6", // 1자릿수 일반 케이스
          "0,10:10", "10,0:10", // 2자릿수 엣지 케이스
          "12,34:46", // 2자릿수 일반 케이스
      }, delimiter = ':')
  @DisplayName(",(comma) 를 delimiter 로 할 때의 결괏값")
  public void commaDelimiter(String input, int expected) {
    int result = StringAddCalculator.splitAndSum(input);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"0:0,0", "0:1,1", "1:0,1",
      "3:5,8",
      "0:10,10", "10:0,10",
      "12:34,46",
  }, delimiter = ',')
  @DisplayName(":(콜론) 을 delimiter 로 할 때의 결괏값")
  public void colonDelimiter(String input, int expected) {
    int result = StringAddCalculator.splitAndSum(input);
    assertThat(result).isEqualTo(expected);
  }
}
