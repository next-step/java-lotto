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
    details.put(Rank.FIRST, 1);
    GameResult result = new GameResult(details);
    Money purchaseAmount = new Money(1000);
    assertThat(result.getProfitMessage(purchaseAmount)).contains("2000000.00");
  }

  @ParameterizedTest
  @CsvSource({"50000,50000,이익", "100000,50000,손해"})
  void testExplanation(int purchaseAmount, int totalPrize, String value) {
    Map<Rank, Integer> details = new HashMap<>();
    details.put(Rank.FOURTH, totalPrize / 50000);
    GameResult result = new GameResult(details);
    assertThat(result.getProfitMessage(new Money(purchaseAmount))).contains(value);
  }

}