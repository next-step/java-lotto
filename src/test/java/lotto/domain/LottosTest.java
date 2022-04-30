package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  void autoCreate() {
    assertThat(Lottos.create(Collections.EMPTY_LIST, 10).size()).isEqualTo(10);
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
    Lotto matchThree = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(30),
        new LottoNumber(40),
        new LottoNumber(45)
    ));
    Lotto matchFour = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(40),
        new LottoNumber(45)
    ));
    Lotto matchFive = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(45)
    ));
    Lotto matchFiveAndBonus = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(7)
    ));
    Lotto matchSix = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    ));
    return new Lottos(List.of(matchThree, matchFour, matchFive, matchFiveAndBonus, matchSix));
  }
}
