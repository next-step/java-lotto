package edu.nextstep.lottocustom.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {
    @Test
    @DisplayName("수익률 계산")
    void calculateRateOfReturn() {
        // given
        Map<Prize, Integer> winningResultMap = createAndInitWinningResult();
        winningResultMap.put(Prize.FIRST, 1);
        int totalPayment = 1_000;

        // when
        WinningResult winningResult = new WinningResult(winningResultMap, totalPayment);

        // then
        assertThat(winningResult.getRateOfReturn()).isEqualTo((double) 2_000_000_000 / 1_000);
    }

    private Map<Prize, Integer> createAndInitWinningResult() {
        Map<Prize, Integer> winningResult = new LinkedHashMap<>();

        Arrays.stream(Prize.values())
                .forEach(prize -> winningResult.put(prize, winningResult.getOrDefault(prize, 0)));

        return winningResult;
    }

}