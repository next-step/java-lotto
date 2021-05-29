package lotto.statistics;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.LottoNumbers;
import lotto.store.Budget;
import lotto.store.Ticket;

public class StatisticsCalculatorTest {

    @Test
    @DisplayName(value = "일치 횟수당 통계를 계산한다")
    void statistics() {
        LottoNumbers win = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));
        StatisticsCalculator calculator = new StatisticsCalculator(mockTicket(), win);
        Map<Ranking, Statistic> countByStatic = calculator.statisticsMap();
        assertThat(countByStatic.get(Ranking.FIFTH)).isEqualTo(new Statistic(1, Earn.THREE_MATCHED));
    }

    @Test
    @DisplayName(value = "이번 로또 게임으로 인해서 총 벌어들인 금액을 계산한다")
    void earningPrice() {
        LottoNumbers win = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));
        StatisticsCalculator calculator = new StatisticsCalculator(mockTicket(), win);
        assertThat(calculator.sumEarningPrice()).isEqualTo(5000 + 50000 + 1500000 + 2000000000);
    }

    @Test
    @DisplayName(value = "통계 결과에 기반하여(이익, 손해, 본전) 출력 메세지를 검증한다")
    void printMessage() {
        LottoNumbers win = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));
        StatisticsCalculator calculator = new StatisticsCalculator(mockTicket(), win);
        String message = "당첨 통계\n"
            + "---------\n"
            + "3개 일치 (5000원)- 1개\n"
            + "4개 일치 (50000원)- 1개\n"
            + "5개 일치 (1500000원)- 1개\n"
            + "6개 일치 (2000000000원)- 1개\n"
            + "총 수익률은 500388.75입니다.(기준이 1이기 때문에 결과적으로 이익라는 의미임)";
        assertThat(calculator.toString()).isEqualTo(message);
    }

    @Test
    @DisplayName(value = "벌어들인 비율을 계산한다")
    void profitOrNot() {
        LottoNumbers win = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));
        StatisticsCalculator calculator = new StatisticsCalculator(mockTicket(), win);
        assertThat(calculator.earningRatio()).isEqualTo(500388.75);
    }

    private Ticket mockTicket() {
        List<LottoNumbers> purchased = new ArrayList() {{
            add(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
            add(new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7)));
            add(new LottoNumbers(Arrays.asList(3, 4, 5, 6, 7, 8)));
            add(new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9)));
        }};
        return new Ticket(purchased, new Budget(4_000));
    }

}
