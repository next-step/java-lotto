package lotto;

import lotto.model.BoughtLotto;
import lotto.model.WinningRecord;
import lotto.model.WinningLotto;
import lotto.service.WinningAnalyzer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningAnalyzerTest {

    @Test
    @DisplayName("구매자의 당첨통계 계산 테스트")
    public void calculateWinningStatistics() {
        List<BoughtLotto> boughtLottos = new ArrayList<>();

        boughtLottos.add(new BoughtLotto(List.of(2, 5, 9, 10, 23, 31))); // 1등 -> 6개
        boughtLottos.add(new BoughtLotto(List.of(2, 5, 9, 10, 23, 16))); // 2등 -> 5개 + 보너스번호
        boughtLottos.add(new BoughtLotto(List.of(2, 5, 9, 10, 23, 12))); // 3등 -> 5개
        boughtLottos.add(new BoughtLotto(List.of(2, 5, 9, 10, 16, 14))); // 4등 -> 4개 + 보너스번호

        Map<Integer, WinningRecord> winningStatics = WinningAnalyzer.calculateWinningStatistics(new WinningLotto("2, 5, 9, 10, 23, 31", 16), boughtLottos);

        assertThat(winningStatics.get(1).getWinningCount()).isEqualTo(1);  // 1등
        assertThat(winningStatics.get(2).getWinningCount()).isEqualTo(1);  // 2등
        assertThat(winningStatics.get(3).getWinningCount()).isEqualTo(1);  // 3등
        assertThat(winningStatics.get(4).getWinningCount()).isEqualTo(1);  // 4등
        assertThat(winningStatics.get(5).getWinningCount()).isEqualTo(0);  // 5등
        assertThat(winningStatics.get(0).getWinningCount()).isEqualTo(0);  // 미당첨
    }

    @Test
    @DisplayName("구매자의 총 수익률 계산 테스트")
    public void calculateReturnRate() {
        List<BoughtLotto> boughtLottos = new ArrayList<>();

        boughtLottos.add(new BoughtLotto(List.of(2, 5, 9, 10, 23, 31)));
        boughtLottos.add(new BoughtLotto(List.of(2, 5, 9, 23, 18, 16)));

        Map<Integer, WinningRecord> winningStatistics = WinningAnalyzer.calculateWinningStatistics(new WinningLotto("2, 5, 9, 41, 7, 44", 16), boughtLottos);

        assertThat(WinningAnalyzer.calculateReturnRate(10000, winningStatistics)).isEqualTo(1.0f);
    }

}
