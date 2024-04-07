package lotto.domain;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 Lottos 테스트")
public class LottosTest {

    @DisplayName("당첨 통계 산출")
    @Test
    void computeStatistic() {
        Lottos lottos = new Lottos(Lotto.ofNumbers(Set.of(1, 2, 3, 4, 5, 6)));
        WinLotto winLotto = new WinLotto(Set.of(1, 2, 3, 4, 5, 7), 6);

        Statistics result = lottos.computeStatistic(winLotto);

        assertThat(result).isEqualTo(new Statistics(List.of(Statistic.SECOND)));
    }

}
