import domain.AutoNumberStrategy;
import domain.Lotto;
import domain.Lottos;
import domain.WinningStatistics;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    /**
     * 어떤 식으로 테스트를 작성해야 좋을 지 몰라서, 이렇게 작성하였습니다...
     */
    @Test
    public void 로또당첨결과찾기_테스트() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(new AutoNumberStrategy())
                , new Lotto(new AutoNumberStrategy())
                , new Lotto(new AutoNumberStrategy())));
        WinningStatistics winningStatistics = new WinningStatistics();

        assertThat(lottos.findWinningLottoResult(new Lotto(new AutoNumberStrategy()), winningStatistics)).isEqualTo(winningStatistics);
    }

}
