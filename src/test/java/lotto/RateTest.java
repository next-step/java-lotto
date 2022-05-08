package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Rate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RateTest {

  @DisplayName("Rate 객체 동등성 테스트")
  @ParameterizedTest
  @ValueSource(doubles = {0.0, 0.1, -0.1, 1.0})
  void createMoney(double rate) {
    assertThat(Rate.of(rate)).isEqualTo(Rate.of(rate));
  }
}