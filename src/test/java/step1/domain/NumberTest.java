package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.exception.AdderException;

class NumberTest {

  @ParameterizedTest
  @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
  void 객체_생성_테스트(String stringInput, int intInput) {
    assertThat(new Number(stringInput)).isEqualTo(new Number(intInput));
  }

  @ParameterizedTest
  @ValueSource(strings = {"-1", "a"})
  void 객체_생성_실패_테스트(String stringInput) {
    assertThrows(AdderException.class, () -> new Number(stringInput));
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "3"})
  void intValue_메소드_테스트(String stringInput) {
    assertThat(new Number(stringInput).intValue()).isEqualTo(Integer.parseInt(stringInput));
  }

  @ParameterizedTest
  @CsvSource(value = {"3:5:8", "4:5:9"}, delimiter = ':')
  void 더하기_연산_테스트(String one, String theOther, String result) {
    assertThat(Number.sum(new Number(one), new Number(theOther))).isEqualTo(new Number(result));
  }
}