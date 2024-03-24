package lotto.domain;

import lotto.domain.PositiveNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberTest {
  @Test
  void 음수_입력으로는_생성할_수_없다() {
    assertThatThrownBy(() -> PositiveNumber.of(-10))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Wrong constructor argument!");
  }

  @ParameterizedTest
  @CsvSource(value = {"4,15", "20,3", "5,12", "6,10"})
  void 주어진_값으로_나눈_몫_반환(int input, int expected) {
    PositiveNumber number = PositiveNumber.of(60);
    assertThat(number.quotient(input)).isEqualTo(PositiveNumber.of(expected));
  }

  @ParameterizedTest
  @CsvSource(value = {"3,false", "5,true"})
  void 더_작다(int input, boolean expected) {
    assertThat(PositiveNumber.of(4).lessThan(PositiveNumber.of(input))).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"3,true", "5,false"})
  void 더_크다(int input, boolean expected) {
    assertThat(PositiveNumber.of(4).greaterThan(PositiveNumber.of(input))).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"3,true", "4,true", "5,false"})
  void 더_크거나_같다(int input, boolean expected) {
    assertThat(PositiveNumber.of(4).greaterOrEqual(PositiveNumber.of(input))).isEqualTo(expected);
  }
}
