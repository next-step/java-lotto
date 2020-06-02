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
        winningList = new ArrayList<>();
        //4등 갯수
        winningList.add(0);
        //3등 갯수
        winningList.add(1);
        //2등 갯수
        winningList.add(1);
        //1등 갯수
        winningList.add(0);

        profitStatistics = new ProfitStatistics(winningList, money);
    }

    @Test
    void profitStatisticsInitTest() {
        assertThat(profitStatistics.getClass().getSimpleName()).isEqualTo("ProfitStatistics");
    }

    @Test
    void profitRatioTest() {
        int sum = Prize.second.getWinningPrize() + Prize.third.getWinningPrize();
        double expectRatio = (double) sum / money;
        assertThat(expectRatio).isEqualTo(profitStatistics.getProfitRatio());
    }

    @Test
    void analysisTest() {
        Map<Prize, Integer> prizeMap = new HashMap<>();
        prizeMap.put(Prize.fouth, 0);
        prizeMap.put(Prize.third, 1);
        prizeMap.put(Prize.second, 1);
        prizeMap.put(Prize.first, 0);

        double profitRatio = profitStatistics.getProfitRatio();
        ResultDTO expectResultDTO = new ResultDTO(prizeMap, profitRatio);
        ResultDTO resultDTO = profitStatistics.analysis();

        assertThat(expectResultDTO).isEqualTo(resultDTO);
    }

}
