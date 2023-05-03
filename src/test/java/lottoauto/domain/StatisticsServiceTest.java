package lottoauto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lottoauto.model.Lotto;
import lottoauto.model.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsServiceTest {

    @Test
    @DisplayName(value = "3개 일치되는 목록이 한개 존재")
    void calculateStatisticsTest() {

        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11)));
        Lottos lottos = new Lottos(List.of(lotto));
        StatisticsService statisticsService = new StatisticsService(lottos);

        String winningNumbers = "1,2,3,4,5,6";
        Map<Integer, AtomicInteger> winningMap = statisticsService.calculateStatistics(winningNumbers);
        Assertions.assertThat(winningMap.get(3).intValue()).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "5개 구매중 3개 일치 시 수익률 1.0")
    void getRevenueRateTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(21, 24, 6, 8, 10, 12))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(22, 30, 8, 10, 12, 14))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(19, 8, 10, 12, 14, 16))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(20, 10, 12, 14, 16, 18))));

        StatisticsService statisticsService = new StatisticsService(new Lottos(lottos));

        String winningNumbers = "1,2,3,4,5,6";
        Map<Integer, AtomicInteger> winningMap = statisticsService.calculateStatistics(winningNumbers);
        double revenueRate = statisticsService.getRevenueRate(winningMap);
        Assertions.assertThat(revenueRate).isEqualTo(1.0);
    }

    @Test
    @DisplayName(value = "당첨 숫자 6자리가 아닐 시 예외처리")
    void winningNumberNotEqualSix() {
        String winningNumber = "1,2,3,4";
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11)));
        Lottos lottos = new Lottos(List.of(lotto));
        StatisticsService statisticsService = new StatisticsService(lottos);

        Assertions.assertThatThrownBy(() -> statisticsService.calculateStatistics(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 숫자는 6개를 입력해야 합니다.");
    }
}