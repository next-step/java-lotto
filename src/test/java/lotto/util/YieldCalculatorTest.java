package lotto.util;

import lotto.domain.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

class YieldCalculatorTest {

    @DisplayName("경기 결과와 구입 금액을 입력하면 수익률을 계산해준다.")
    @Test
    void name() {
        Map<Ranking, Integer> winningMap = new HashMap<>();
        winningMap.put(FIRST, 0);
        winningMap.put(SECOND, 1);
        winningMap.put(THIRD, 2);
        winningMap.put(FOURTH, 3);

        assertThat(YieldCalculator.calculate(winningMap, 2000000)).isEqualTo(0.8075);
    }
}