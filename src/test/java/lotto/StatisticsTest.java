package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  Statistics statistics;

  @BeforeEach
  public void setup() {
    Lotto lastWeekWinLotto = makeLotto("1,2,3,4,5,6");

    Lotto purchaseLotto1 = makeLotto("11,12,13,14,15,17");
    Lotto purchaseLotto2 = makeLotto("11,12,13,14,17,18");
    Lotto purchaseLotto3 = makeLotto("1,2,3,7,8,9");

    List<Lotto> purchasedLotto = new ArrayList<>();
    purchasedLotto.add(purchaseLotto1);
    purchasedLotto.add(purchaseLotto2);
    purchasedLotto.add(purchaseLotto3);
    Lottos lottos = new Lottos(purchasedLotto);

    statistics = new Statistics(lottos, lastWeekWinLotto);
  }

  @Test
  public void 일치하는숫자가있는_로또갯수를_구해온다() {

    assertThat(statistics.getSameNumberCount(3)).isEqualTo(1);
    assertThat(statistics.getSameNumberCount(4)).isEqualTo(0);
    assertThat(statistics.getSameNumberCount(5)).isEqualTo(0);

  }

  @Test
  public void 수익률을구해온다() {
    assertThat(statistics.getYield()).isEqualTo(1.66);

  }

  private Lotto makeLotto(String input) {
    List<Integer> result = new ArrayList<>();
    int[] numbers = Arrays.stream(input.split(","))
        .mapToInt(Integer::parseInt).toArray();
    for (int number : numbers) {
      result.add(number);
    }
    return new Lotto(result);

  }
}