package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  Statistics statistics;

  @BeforeEach
  public void setup() {
    LastWeekWinLotto lastWeekWinLotto = new LastWeekWinLotto("1,2,3,4,5,6", 20);

    Lotto purchaseLotto1 = new Lotto("1,2,3,4,5,20");
    Lotto purchaseLotto2 = new Lotto("1,2,3,14,17,18");
    Lotto purchaseLotto3 = new Lotto("1,2,3,4,8,9");

    List<Lotto> purchasedLotto = new ArrayList<>();
    purchasedLotto.add(purchaseLotto1);
    purchasedLotto.add(purchaseLotto2);
    purchasedLotto.add(purchaseLotto3);
    Lottos lottos = new Lottos(purchasedLotto);

    statistics = new Statistics(lottos, lastWeekWinLotto);
  }

  @Test
  public void RankList를_가지고_온다() {
    assertThat(statistics.rankResult()).hasSize(3);
    assertThat(statistics.rankResult()).containsExactly(Rank.SECOND, Rank.FIFTH, Rank.FOURTH);
  }
}