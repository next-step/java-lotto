package lotto;

import lotto.model.Lotto;
import lotto.model.WinningInfo;
import lotto.service.LottoRank;
import lotto.service.LottoAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoAnalyzerTest {

    @Test
    public void 당첨통계_계산() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto(List.of(2, 5, 9, 10, 23, 31))); // 1등 -> 6개
        lottos.add(new Lotto(List.of(2, 5, 9, 10, 23, 16))); // 2등 -> 5개 + 보너스번호
        lottos.add(new Lotto(List.of(2, 5, 9, 10, 23, 12))); // 3등 -> 5개
        lottos.add(new Lotto(List.of(2, 5, 9, 10, 16, 14))); // 4등 -> 4개 + 보너스번호

        List<Integer> winningNumbers = List.of(2, 5, 9, 10, 23, 31);
        int bonusNumber = 16;

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer();

        Map<Integer, WinningInfo> winningStatics = lottoAnalyzer.calculateWinningStatics(winningNumbers, bonusNumber, lottos);

        assertThat(winningStatics.get(1).getWinningCount()).isEqualTo(1);  // 1등
        assertThat(winningStatics.get(2).getWinningCount()).isEqualTo(1);  // 2등
        assertThat(winningStatics.get(3).getWinningCount()).isEqualTo(1);  // 3등
        assertThat(winningStatics.get(4).getWinningCount()).isEqualTo(1);  // 4등
        assertThat(winningStatics.get(5).getWinningCount()).isEqualTo(0);  // 5등
        assertThat(winningStatics.get(0).getWinningCount()).isEqualTo(0);  // 미당첨
    }

    @Test
    public void 총수익률_계산() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto(List.of(2, 5, 9, 10, 23, 31)));
        lottos.add(new Lotto(List.of(2, 5, 9, 23, 18, 16)));

        List<Integer> winningNumbers = List.of(2, 5, 9, 41, 7, 44);
        int bonusNumber = 16;

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer();

        Map<Integer, WinningInfo> winningStatics = lottoAnalyzer.calculateWinningStatics(winningNumbers, bonusNumber, lottos);

        assertThat(lottoAnalyzer.calculateReturnRate(10000)).isEqualTo(1.0f);
    }

}
