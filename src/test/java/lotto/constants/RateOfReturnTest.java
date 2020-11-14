package lotto.constants;

import lotto.exception.LottoGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RateOfReturnTest {

  @ParameterizedTest
  @MethodSource("provideEnum")
  void 수익률_반환_테스트(double number, RateOfReturn expect) {
    assertThat(RateOfReturn.of(number)).isEqualTo(expect);
  }

  @Test
  void 수익률_음수_테스트() {
    double given = -1.1D;
    assertThrows(LottoGameException.class, () -> RateOfReturn.of(given));
  }

  static Stream<Arguments> provideEnum() {
    return Stream.of(
        Arguments.of(0.1D, RateOfReturn.LOSS),
        Arguments.of(1D, RateOfReturn.SAME),
        Arguments.of(2D, RateOfReturn.GAIN)
    );
  }
}