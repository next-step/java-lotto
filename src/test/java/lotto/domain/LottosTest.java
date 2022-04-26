package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  void autoCreate() {
    assertThat(Lottos.autoCreate(10).size()).isEqualTo(10);
  }

  @Test
  void calculate() {
    Lotto lotto = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    ));
    Lottos lottos = prepareLottos();

    Map<Rank, Integer> rankMap = lottos.calculate(lotto);
    assertThat(rankMap.get(Rank.FIRST)).isEqualTo(1);
    assertThat(rankMap.get(Rank.SECOND)).isEqualTo(1);
    assertThat(rankMap.get(Rank.THIRD)).isEqualTo(1);
    assertThat(rankMap.get(Rank.FOURTH)).isEqualTo(1);
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
    Lotto matchSix = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    ));
    return new Lottos(List.of(matchThree, matchFour, matchFive, matchSix));
  }
}
