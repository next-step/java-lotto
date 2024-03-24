package step2_lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class WinningStaticTest {

    @DisplayName("초기 당첨통계는 당첨 기준인 3이상부터 0으로 세팅된다.")
    @Test
    void initialize() {
        WinningStatic winningStatic = new WinningStatic();

        LinkedHashMap<Long, Integer> resultMap = new LinkedHashMap<>();
        resultMap.put(3L, 0);
        resultMap.put(4L, 0);
        resultMap.put(5L, 0);
        resultMap.put(6L, 0);
        WinningStatic result = new WinningStatic(resultMap);

        Assertions.assertThat(winningStatic)
                .usingRecursiveComparison()
                .isEqualTo(result);
    }

    @DisplayName("당첨 등수 별 당첨 된 횟수를 저장한다.")
    @Test
    void countHitNumber() {
        WinningStatic winningStatic = new WinningStatic();
        winningStatic.countHitNumber(3L);
        winningStatic.countHitNumber(3L);

        LinkedHashMap<Long, Integer> resultMap = new LinkedHashMap<>();
        resultMap.put(3L, 2);
        resultMap.put(4L, 0);
        resultMap.put(5L, 0);
        resultMap.put(6L, 0);
        WinningStatic result = new WinningStatic(resultMap);

        Assertions.assertThat(winningStatic)
                .usingRecursiveComparison()
                .isEqualTo(result);
    }

    @DisplayName("당첨 등수 별 당첨 된 횟수를 저장한다. - 당첨 기준 이하는 저장하지 않는다.")
    @Test
    void countHitNumber_under() {
        WinningStatic winningStatic = new WinningStatic();
        winningStatic.countHitNumber(2L);
        winningStatic.countHitNumber(2L);

        LinkedHashMap<Long, Integer> resultMap = new LinkedHashMap<>();
        resultMap.put(3L, 0);
        resultMap.put(4L, 0);
        resultMap.put(5L, 0);
        resultMap.put(6L, 0);
        WinningStatic result = new WinningStatic(resultMap);

        Assertions.assertThat(winningStatic)
                .usingRecursiveComparison()
                .isEqualTo(result);
    }

    @DisplayName("당첨 등수 별 금액에 따라 전체 이익을 계산한다. 3등에 2번 당첨 규칙에 있는 금액 * 횟수")
    @Test
    void calculateTotalRevenue() {
        LinkedHashMap<Long, Integer> winningMap = new LinkedHashMap<>();
        winningMap.put(3L, 2);
        winningMap.put(4L, 0);
        winningMap.put(5L, 0);
        winningMap.put(6L, 0);
        WinningStatic winningStatic = new WinningStatic(winningMap);

        Assertions.assertThat(winningStatic.calculateTotalRevenue())
                .isEqualTo(WinningRule.findRevenue(3L) * 2);
    }

    @DisplayName("지출 대비 수익률을 계산한다. - 수익이 배일 경우")
    @Test
    void returnRate_high_return() {
        int expend = 10000;
        WinningStatic winningStatic = new WinningStatic(100000);
        Assertions.assertThat(winningStatic.returnRate(expend))
                .isEqualTo(10.0);
    }

    @DisplayName("지출 대비 수익률을 계산한다. - 수익이 1 이하일 경우")
    @Test
    void returnRate_low_return() {
        int expend = 10000;
        WinningStatic winningStatic = new WinningStatic(1000);
        Assertions.assertThat(winningStatic.returnRate(expend))
                .isEqualTo(0.1);
    }
}