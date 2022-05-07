package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
    WinningLotto winningLotto = WinningLotto.create("1, 2, 3, 4, 5, 6", 10);

    // when
    int matchResult = lottos.matchLottoRankResult(LottoRank.FIRST, winningLotto);

    // then
    assertThat(matchResult).isEqualTo(3);
  }

  @Test
  @DisplayName("구매한 로또 전체와 우승 로또번호를 비교 결과에 따른 수익률 계산하기")
  void calculateReturnProfitRatioWinningLottoAndComparisonResult() {
    // given
    Lottos lottos = Lottos.create(3, new FixedNumberGenerateStrategy());
    WinningLotto winningLotto = WinningLotto.create("1, 2, 3, 4, 5, 6", 10);

    // when
    double rewordResult = lottos.calculateProfitRatio(winningLotto);

    // then
    assertThat(rewordResult).isEqualTo(2000000.0);
  }

  @Test
  @DisplayName("보너스번호를 맞춘 2등의 경우 수익률 계산하기")
  void calculateReturnProfitRatioBonusSecond() {
    // given
    Lottos lottos = new Lottos(List.of(Lotto.create("1, 2, 3, 4, 5, 10")));
    WinningLotto winningLotto = WinningLotto.create("1, 2, 3, 4, 20, 30", 10);

    // when
    double profit = lottos.calculateProfitRatio(winningLotto);

    // then
    assertThat(profit).isEqualTo(30000.0);
  }

  @Test
  @DisplayName("보너스번호를 맞추지 않고 2등의 경우 수익률 계산하기")
  void calculateReturnProfitRatioSecond() {
    // given
    Lottos lottos = new Lottos(List.of(Lotto.create("1, 2, 3, 4, 5, 20")));
    WinningLotto winningLotto = WinningLotto.create("1, 2, 3, 4, 5, 30", 10);

    // when
    double profit = lottos.calculateProfitRatio(winningLotto);

    // then
    assertThat(profit).isEqualTo(1500.0);
  }
}
