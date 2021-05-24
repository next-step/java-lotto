package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GainLossDiscriminatorTest {

  @DisplayName("손익률의 범위에 알맞은 숫자가 입력되면 손익을 나타내는 enum 반환")
  @ParameterizedTest
  @CsvSource(value = {"1D:SAME", "0D:LOSS", "1.1D:GAIN", "0.5D:LOSS", "100D:GAIN"}, delimiter = ':')
  void testMatchedRanking(double givenYield, GainLossDiscriminator expectation) {
    assertThat(GainLossDiscriminator.of(givenYield)).isSameAs(expectation);
  }

  @DisplayName("손익률의 범위에 알맞지 않은 숫자가 입력되면 IllegalArgumentException 던짐")
  @ParameterizedTest
  @ValueSource(doubles = {-1.1D, -0.1D, -1000D})
  void testNoneMatchedRanking(double givenYield) {
    assertThatThrownBy(() -> GainLossDiscriminator.of(givenYield)).isInstanceOf(IllegalArgumentException.class);
  }

}
