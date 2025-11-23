package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.game.Rank;
import lotto.domain.lotto.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {

  @Test
  void testCalculateProfitRate() {
    Map<Rank, Integer> details = new HashMap<>();
    GameResult result = new GameResult(details, new Money(2000000000), new Money(1000));
    assertThat(result.toString()).contains(String.valueOf((float) 2000000000 / 1000));
  }

  @ParameterizedTest
  @CsvSource({"1,이익", "0.999,손해"})
  void testExplanation(BigDecimal profit, String value) {
    Map<Rank, Integer> details = new HashMap<>();
    GameResult result = new GameResult(details, profit);
    assertThat(result.toString()).contains(value);
  }

}