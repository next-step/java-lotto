package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningRank;
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
  @DisplayName("로또 결과 1등~4등까지의 당첨 통계를 생성한다.")
  void createLottoStatistics() {
    Lotto lotto1 = Lotto.of("1, 2, 3, 4, 5, 6");
    Lotto lotto2 = Lotto.of("1, 2, 3, 4, 5, 7");
    Lotto lotto3 = Lotto.of("1, 2, 3, 4, 7, 8");
    Lotto lotto4 = Lotto.of("1, 2, 3, 7, 8, 9");

    LottoSet lottoSet = LottoMachine.generateManualLotto(new LottoPurchase(4000), List.of(lotto1, lotto2, lotto3, lotto4));
    Lotto winningLotto = Lotto.of("1, 2, 3, 4, 5, 6");

    LottoResult lottoResult = lottoSet.calculateResult(winningLotto);

    for (WinningRank rank : WinningRank.values()) {
      int count = lottoResult.getMatchCount().getOrDefault(rank, 0);
      assertThat(count).isEqualTo(1);
    }
  }

  @Test
  @DisplayName("로또 결과 총 수익률을 계산한다.")
  void createLottoProfitRate() {
    Lotto lotto1 = Lotto.of("1, 2, 3, 4, 5, 6");
    Lotto lotto2 = Lotto.of("1, 2, 3, 4, 5, 7");
    Lotto lotto3 = Lotto.of("1, 2, 3, 4, 7, 8");
    Lotto lotto4 = Lotto.of("1, 2, 3, 7, 8, 9");

    LottoSet lottoSet = LottoMachine.generateManualLotto(new LottoPurchase(4000), List.of(lotto1, lotto2, lotto3, lotto4));
    Lotto winningLotto = Lotto.of("1, 2, 3, 4, 5, 6");

    LottoResult lottoResult = lottoSet.calculateResult(winningLotto);

    assertThat(lottoResult.getProfitRate()).isEqualTo(500388.75);
  }
}
