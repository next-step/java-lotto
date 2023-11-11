package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinningStatistics;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningStatisticsTest {

    @Test
    @DisplayName("당첨 통계에서 n개 일치하는 로또의 개수를 구할 수 있다")
    public void winning_statistics() {
        Lotto twoMatchLotto = new Lotto(Arrays.asList(9, 10, 41, 42, 43, 44));
        Lotto threeMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto prizeLotto = new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11));
        Lottos lottos = new Lottos(Arrays.asList(twoMatchLotto, threeMatchLotto));
        WinningStatistics winningStatistics = lottos.winningStatistics(prizeLotto);

        assertThat(winningStatistics.winningLottosCount(2)).isEqualTo(1);
        assertThat(winningStatistics.winningLottosCount(3)).isEqualTo(1);
    }

}
