package Lotto;

import lotto.domain.Statistic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

public class StatisticTest {

    @Test
    @DisplayName("로또 각각 맞은 수에대한 통계를 잘 구하는지 확인")
    public void mapTest(){
        Map<Long, Integer> countLottoPerCorrectNum = Statistic.countLottoPerCorrectNum(Arrays.asList(1L, 3L, 5L, 1L, 3L, 6L));
        Assertions.assertThat(countLottoPerCorrectNum.get(3L)).isEqualTo(2);
    }

    @Test
    @DisplayName("수익률을 잘 구하는지 확인")
    public void revenueRate(){
        Map<Long, Integer> countLottoPerCorrectNum = Statistic.countLottoPerCorrectNum(Arrays.asList(1L, 3L, 0L, 1L, 0L));
        double revenueRate = Statistic.getRevenueRate(5000,countLottoPerCorrectNum);
        Assertions.assertThat(revenueRate).isEqualTo(1);
    }
}
