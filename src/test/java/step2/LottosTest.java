package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinningStatistics;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {

    @Test
    @DisplayName("우승 번호로부터 당첨 통계를 생성할 수 있다")
    public void winning_statistics() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto prizeLotto = new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11));
        Lottos lottos = new Lottos(Arrays.asList(lotto));

        assertThat(lottos.winningStatistics(prizeLotto)).isInstanceOf(WinningStatistics.class);
    }

}
