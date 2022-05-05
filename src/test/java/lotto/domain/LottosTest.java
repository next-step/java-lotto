package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  void autoCreate() {
    assertThat(Lottos.create(Collections.emptyList(), 10).size()).isEqualTo(10);
  }

  @Test
  void manualAndAutoCreate() {
    List<Lotto> manualLottos = List.of(
        Lotto.create(Set.of(1, 2, 3, 30, 40, 45)),
        Lotto.create(Set.of(1, 2, 3, 4, 40, 45))
    );
    assertThat(Lottos.create(manualLottos, 8).size()).isEqualTo(10);
  }

  @Test
  void calculate() {
    WinningLotto lotto = WinningLotto.create(Set.of(1, 2, 3, 4, 5, 6), 7);
    Lottos lottos = prepareLottos();

    LottoResult result = lottos.calculate(lotto);
    assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(1);
    assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(1);
    assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(1);
    assertThat(result.getRankCount(Rank.FOURTH)).isEqualTo(1);
    assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(1);
  }

  private Lottos prepareLottos() {
    Lotto matchThree = Lotto.create(Set.of(1, 2, 3, 30, 40, 45));
    Lotto matchFour = Lotto.create(Set.of(1, 2, 3, 4, 40, 45));
    Lotto matchFive = Lotto.create(Set.of(1, 2, 3, 4, 5, 45));
    Lotto matchFiveAndBonus = Lotto.create(Set.of(1, 2, 3, 4, 5, 7));
    Lotto matchSix = Lotto.create(Set.of(1, 2, 3, 4, 5, 6));
    return new Lottos(List.of(matchThree, matchFour, matchFive, matchFiveAndBonus, matchSix));
  }
}
