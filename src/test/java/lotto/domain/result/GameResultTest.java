package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.game.Rank;
import lotto.domain.lotto.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {

  @Test
  void getTotalPrize_first() {
    Map<Rank, Integer> details = new HashMap<>();
    details.put(Rank.FIRST, 1);
    GameResult result = new GameResult(details);

    assertThat(result.getTotalPrize()).isEqualTo(new Money(2_000_000_000));
  }

  @ParameterizedTest
  @CsvSource({"1, 50000", "2, 100000", "3, 150000"})
  void getTotalPrize_fourth(int count, int expectedPrize) {
    Map<Rank, Integer> details = new HashMap<>();
    details.put(Rank.FOURTH, count);
    GameResult result = new GameResult(details);

    assertThat(result.getTotalPrize()).isEqualTo(new Money(expectedPrize));
  }
}