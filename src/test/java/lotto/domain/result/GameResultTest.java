package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.game.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {

  @Test
  void testCalculateProfitRate() {
    Map<Rank, Integer> details = new HashMap<>();
    GameResult result = new GameResult(details, 2000000000, 1000);
    assertThat(result.toString()).contains(String.valueOf((float) 2000000000 / 1000));
  }

  @ParameterizedTest
  @CsvSource({"1,이익", "0.999,손해"})
  void testExplanation(float profit, String value) {
    Map<Rank, Integer> details = new HashMap<>();
    GameResult result = new GameResult(details, profit);
    assertThat(result.toString()).contains(value);
  }

  @Test
  void divisionByZeroThrowException() {
    Map<Rank, Integer> details = new HashMap<>();
    assertThatThrownBy(() -> new GameResult(details, 1000, 0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("구매 금액은 0보다 커야 합니다");
  }

  @Test
  void negativeWinningPrizeThrowException() {
    Map<Rank, Integer> details = new HashMap<>();
    assertThatThrownBy(() -> new GameResult(details, -1000, 1000))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("당첨 금액은 0 이상이어야 합니다");
  }

}