package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResultAnalyzer;
import lotto.domain.result.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultAnalyzerTest {

  @Test
  @DisplayName("로또 결과 분석기는 1등~4등까지의 당첨 통계를 생성한다.")
  void createLottoStatistics() {
    Lotto lotto1 = Lotto.of("1, 2, 3, 4, 5, 6");
    Lotto lotto2 = Lotto.of("1, 2, 3, 4, 5, 7");
    Lotto lotto3 = Lotto.of("1, 2, 3, 4, 7, 8");
    Lotto lotto4 = Lotto.of("1, 2, 3, 7, 8, 9");

    LottoSet lottoSet = LottoMachine.generateManualLotto(List.of(lotto1, lotto2, lotto3, lotto4));
    Lotto winningLotto = Lotto.of("1, 2, 3, 4, 5, 6");

    LottoResultAnalyzer analyzer = new LottoResultAnalyzer();
    LottoResult lottoResult = analyzer.analyze(lottoSet, winningLotto);

    for (WinningRank rank : WinningRank.values()) {
      int count = lottoResult.getMatchCount().getOrDefault(rank, 0);
      assertThat(count).isEqualTo(1);
    }
  }

  @Test
  @DisplayName("로또 결과 분석기는 총 수익률을 계산한다.")
  void createLottoProfitRate() {
    Lotto lotto1 = Lotto.of("1, 2, 3, 4, 5, 6");
    Lotto lotto2 = Lotto.of("1, 2, 3, 4, 5, 7");
    Lotto lotto3 = Lotto.of("1, 2, 3, 4, 7, 8");
    Lotto lotto4 = Lotto.of("1, 2, 3, 7, 8, 9");

    LottoSet lottoSet = LottoMachine.generateManualLotto(List.of(lotto1, lotto2, lotto3, lotto4));
    Lotto winningLotto = Lotto.of("1, 2, 3, 4, 5, 6");

    LottoResultAnalyzer analyzer = new LottoResultAnalyzer();
    LottoResult lottoResult = analyzer.analyze(lottoSet, winningLotto);

    assertThat(lottoResult.getProfitRate()).isEqualTo(500388.75);
  }
}
