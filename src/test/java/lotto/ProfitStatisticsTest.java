package lotto;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.ProfitStatistics;
import lotto.domain.ResultDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitStatisticsTest {

    ProfitStatistics profitStatistics;
    List<Integer> winningList;
    int money;

    @BeforeEach
    void setUp() {
        money = 5000;
        Map<Prize, Integer> winningList = new HashMap<>();
        winningList.put(Prize.SECOND, 1);
        winningList.put(Prize.THIRD, 1);
        profitStatistics = new ProfitStatistics(winningList, money);
    }

    @Test
    void profitStatisticsInitTest() {
        assertThat(profitStatistics.getClass().getSimpleName()).isEqualTo("ProfitStatistics");
    }

    @Test
    void profitRatioTest() {
        int sum = Prize.SECOND.getWinningPrize() + Prize.THIRD.getWinningPrize();
        double expectRatio = (double) sum / money;
        assertThat(expectRatio).isEqualTo(profitStatistics.getProfitRatio());
    }
}
