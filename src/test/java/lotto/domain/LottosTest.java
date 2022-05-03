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
        new Lotto(Set.of(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(30),
            LottoNumber.of(40),
            LottoNumber.of(45)
        )),
        new Lotto(Set.of(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(40),
            LottoNumber.of(45)
        ))
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
    Lotto matchThree = new Lotto(Set.of(
        LottoNumber.of(1),
        LottoNumber.of(2),
        LottoNumber.of(3),
        LottoNumber.of(30),
        LottoNumber.of(40),
        LottoNumber.of(45)
    ));
    Lotto matchFour = new Lotto(Set.of(
        LottoNumber.of(1),
        LottoNumber.of(2),
        LottoNumber.of(3),
        LottoNumber.of(4),
        LottoNumber.of(40),
        LottoNumber.of(45)
    ));
    Lotto matchFive = new Lotto(Set.of(
        LottoNumber.of(1),
        LottoNumber.of(2),
        LottoNumber.of(3),
        LottoNumber.of(4),
        LottoNumber.of(5),
        LottoNumber.of(45)
    ));
    Lotto matchFiveAndBonus = new Lotto(Set.of(
        LottoNumber.of(1),
        LottoNumber.of(2),
        LottoNumber.of(3),
        LottoNumber.of(4),
        LottoNumber.of(5),
        LottoNumber.of(7)
    ));
    Lotto matchSix = new Lotto(Set.of(
        LottoNumber.of(1),
        LottoNumber.of(2),
        LottoNumber.of(3),
        LottoNumber.of(4),
        LottoNumber.of(5),
        LottoNumber.of(6)
    ));
    return new Lottos(List.of(matchThree, matchFour, matchFive, matchFiveAndBonus, matchSix));
  }
}
