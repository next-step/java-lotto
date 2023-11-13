package lottoauto.domain.aggregate;

import lottoauto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AggregatorTest {

    @Test
    @DisplayName("일치하는 당첨 로또들을 일치 수에 맞도록 winnerBoard 에 추가합니다.")
    void checkLotto() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Aggregator aggregator = new Aggregator(List.of(lotto));
        // when
        WinnerBoard winnerBoard = aggregator.checkWinnerLotto(List.of(4, 5, 6, 7, 8, 9));
        // then
        assertThat(winnerBoard).isEqualTo(new WinnerBoard(Map.of(
                3, 1,
                4, 0,
                5, 0,
                6, 0
        )));
    }

    @Test
    @DisplayName("상금 보드를 이용해 총 수익률을 계산해줍니다.")
    void calculateEarningRate() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        Aggregator aggregator = new Aggregator(List.of(lotto1, lotto2, lotto3));
        aggregator.checkWinnerLotto(List.of(4, 5, 6, 7, 8, 9));
        // when
        double earningRate = aggregator.calculateEarningRate();
        // then
        assertThat(earningRate).isEqualTo(3.33);
    }

    @Test
    @DisplayName("총 수익률이 0이 나오는 경우")
    void zeroEarningRate() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        Aggregator aggregator = new Aggregator(List.of(lotto1, lotto2, lotto3));
        aggregator.checkWinnerLotto(List.of(21, 22, 23, 24, 25, 26));
        // when
        double earningRate = aggregator.calculateEarningRate();
        // then
        assertThat(earningRate).isEqualTo(0);
    }
}