package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinningStatistics;
import step2.domain.type.Prize;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningStatisticsTest {

    @Test
    @DisplayName("당첨 통계에서 n개 일치하는 로또의 개수를 구할 수 있다")
    public void winning_statistics() {
        WinningStatistics winningStatistics = winningStatistics();

        assertThat(winningStatistics.winningLottosCount(Prize.of(3))).isEqualTo(1);
        assertThat(winningStatistics.winningLottosCount(Prize.of(4))).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 통계로부터 수익률을 계산할 수 있다")
    public void rate_of_return() {
        WinningStatistics winningStatistics = winningStatistics();

        assertThat(winningStatistics.rateOfReturn(BigDecimal.valueOf(14000))).isEqualTo(BigDecimal.valueOf(3.93));
    }

    private WinningStatistics winningStatistics() {
        Lotto threeMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto fourMatchLotto = new Lotto(Arrays.asList(3, 9, 10, 11, 42, 43));
        Lotto prizeLotto = new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11));
        Lottos lottos = new Lottos(Arrays.asList(threeMatchLotto, fourMatchLotto));

        return lottos.winningStatistics(prizeLotto);
    }

}
