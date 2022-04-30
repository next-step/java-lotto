package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.strategy.FixedNumberGenerateStrategy;
import lotto.strategy.RandomNumberGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  @DisplayName("구매한 로또의 갯수만큼 로또 객체 생성")
  void createLottoObjectNumberOfPurchasedLotto() {
    // given
    int purchasedLotto = 3;

    // when
    Lottos lottos = Lottos.create(purchasedLotto, new RandomNumberGenerateStrategy());

    // then
    assertThat(lottos.getLottos()).hasSize(purchasedLotto);
  }

  @Test
  @DisplayName("구매한 로또 전체와 우승 로또번호를 비교한 결과")
  void checkResultOfCompareAllPurchasedLottoAndWinningLotto() {
    // given
    Lottos lottos = Lottos.create(3, new FixedNumberGenerateStrategy());
    WinningLotto winningLotto = WinningLotto.create("1, 2, 3, 4, 5, 6");

    // when
    int matchResult = lottos.matchLottoRankResult(LottoRank.FIRST, winningLotto);

    // then
    assertThat(matchResult).isEqualTo(3);
  }
}
