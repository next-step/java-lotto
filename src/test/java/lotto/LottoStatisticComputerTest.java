package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 LottoStatistic 테스트")
public class LottoStatisticComputerTest {

    private LottoStatisticComputer lottoStatisticComputer;

    @BeforeEach
    void initComputer() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 4, 5, 6, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 5, 6, 7, 8));

        lottoStatisticComputer = new LottoStatisticComputer(List.of(lotto1, lotto2, lotto3));
    }


    @DisplayName("당첨 통계 산출")
    @Test
    void computeStatistic_three() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Statistics result = lottoStatisticComputer.computeStatistic(winLotto);

        assertThat(result.statistics).isEqualTo(new Statistics(List.of(Statistic.SIX, Statistic.FIVE, Statistic.FOUR)).statistics);
    }
}
