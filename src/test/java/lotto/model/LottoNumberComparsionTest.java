package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.strategy.FixedNumberGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberComparsionTest {

  @Test
  @DisplayName("우승한 로또번호와 구매한 로또번호를 비교한 전체 결과확인")
  void checkAllResultOfCompareAllPurchasedLottoAndWinningLotto() {
    // given
    Lottos lottos = Lottos.create(3, new FixedNumberGenerateStrategy());
    WinningLotto winningLotto = WinningLotto.create("1, 2, 3, 4, 5, 6");

    // when
    LottoNumberComparsion lottoNumberComparsion = new LottoNumberComparsion(lottos, winningLotto);
    Map<LottoRank, Integer> matchResult = lottoNumberComparsion.getMatchResult();

    // then
    assertThat(matchResult.get(LottoRank.FIRST)).isEqualTo(3);
  }
}