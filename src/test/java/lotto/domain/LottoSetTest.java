package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSetTest {

  @Test
  @DisplayName("로또 갯수만큼 로또가 생성된다.")
  void generateRandomLotto() {
    LottoSet lottoSet = new LottoSet(new LottoPurchase(14000), new RandomLottoGenerator());
    assertThat(lottoSet.size()).isEqualTo(14);
  }


  @Test
  @DisplayName("로또 결과 1등~5등까지의 당첨 통계를 생성한다.")
  void createLottoStatistics() {
    Lotto lotto1 = Lotto.of("1, 2, 3, 4, 5, 6");  // 6개(1등)
    Lotto lotto2 = Lotto.of("1, 2, 3, 4, 5, 30"); // 5개+보너스(2등)
    Lotto lotto3 = Lotto.of("1, 2, 3, 4, 5, 7");  // 5개(3등)
    Lotto lotto4 = Lotto.of("1, 2, 3, 4, 7, 8");  // 4개(4등)
    Lotto lotto5 = Lotto.of("1, 2, 3, 7, 8, 9");  // 3개(3등)

    LottoSet lottoSet = LottoMachine.generateManualLotto(new LottoPurchase(5000), List.of(lotto1, lotto2, lotto3, lotto4, lotto5));
    WinningLotto winningLottoWithBonus = new WinningLotto(Lotto.of("1, 2, 3, 4, 5, 6"), LottoNumber.of("30"));
    LottoResult lottoResult = lottoSet.provideLottoResult(winningLottoWithBonus);

    assertThat(lottoResult.getMatchCount()).containsExactlyInAnyOrderEntriesOf(Map.of(
        WinningRank.SIX_MATCH, 1,
        WinningRank.FIVE_MATCH_BONUS, 1,
        WinningRank.FIVE_MATCH, 1,
        WinningRank.FOUR_MATCH, 1,
        WinningRank.THREE_MATCH, 1
    ));
  }

  @Test
  @DisplayName("5개 번호 + 보너스번호가 같을 경우 2등이다. (단일테스트)")
  void createLottoStatisticsWithBonus() {
    Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 30");
    LottoSet lottoSet = LottoMachine.generateManualLotto(new LottoPurchase(1000), List.of(lotto));
    WinningLotto winningLottoWithBonus = new WinningLotto(Lotto.of("1, 2, 3, 4, 5, 6"), LottoNumber.of("30"));
    LottoResult lottoResult = lottoSet.provideLottoResult(winningLottoWithBonus);

    assertThat(lottoResult.getMatchCount().get(WinningRank.FIVE_MATCH_BONUS)).isEqualTo(1);
  }

  @Test
  @DisplayName("로또 결과 총 수익률을 계산한다.")
  void createLottoProfitRate() {
    Lotto lotto1 = Lotto.of("1, 2, 3, 4, 5, 6");
    Lotto lotto2 = Lotto.of("1, 2, 3, 4, 5, 30");
    Lotto lotto3 = Lotto.of("1, 2, 3, 4, 5, 7");
    Lotto lotto4 = Lotto.of("1, 2, 3, 4, 7, 8");
    Lotto lotto5 = Lotto.of("1, 2, 3, 7, 8, 9");

    LottoSet lottoSet = LottoMachine.generateManualLotto(new LottoPurchase(5000), List.of(lotto1, lotto2, lotto3, lotto4, lotto5));
    WinningLotto winningLottoWithBonus = new WinningLotto(Lotto.of("1, 2, 3, 4, 5, 6"), LottoNumber.of("30"));
    LottoResult lottoResult = lottoSet.provideLottoResult(winningLottoWithBonus);

    assertThat(lottoResult.getProfitRate()).isEqualTo(406311.0);
  }
}
