package study.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {

  @DisplayName("게임결과 생성 후 당첨금액을 조회할 수 있다.")
  @Test
  public void gameResult_getPrizeMoney() {
    Map<Rank, Integer> prizeStaticsMap = new HashMap<>();
    prizeStaticsMap.put(Rank.MISS, 1);
    prizeStaticsMap.put(Rank.THIRD, 1);
    prizeStaticsMap.put(Rank.SECOND, 2);

    GameResult gameResult = new GameResult(prizeStaticsMap);

    assertThat(gameResult.getPrizeMoney())
        .isEqualTo(new Money(Rank.THIRD.getWinningMoney() + (Rank.SECOND.getWinningMoney() * 2)));
  }
}
