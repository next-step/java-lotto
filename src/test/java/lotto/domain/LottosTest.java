package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 Lottos 테스트")
public class LottosTest {

    @DisplayName("당첨 통계 산출")
    @Test
    void computeStatistic_three() {
        Lotto givenLotto = Lotto.ofNumbers(List.of(1,2,3,4,5,6));
        Lottos lottos = new Lottos(List.of(givenLotto));
        WinLotto winLotto = WinLotto.ofNumbers(List.of(1, 2, 3, 4, 5, 7), 6);

        Statistics result = lottos.computeStatistic(winLotto);

        assertThat(result).isEqualTo(new Statistics(List.of(Statistic.SECOND)));
    }

}
