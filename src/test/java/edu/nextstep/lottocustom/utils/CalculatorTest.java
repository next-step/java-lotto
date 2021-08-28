package edu.nextstep.lottocustom.utils;

import edu.nextstep.lottocustom.domain.Payment;
import edu.nextstep.lottocustom.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("수익률 계산")
    void calculateRateOfReturn() {
        // given
        Map<Prize, Integer> winningResult = createAndInitWinningResult();
        winningResult.put(Prize.FIRST, 1);
        Payment payment = new Payment(10_000);

        // when
        double rateOfReturn = Calculator.calculateRateOfReturn(winningResult, payment);

        // then
        assertThat(rateOfReturn).isEqualTo((double) 2_000_000_000 / 10_000);
    }

    private Map<Prize, Integer> createAndInitWinningResult() {
        Map<Prize, Integer> winningResult = new LinkedHashMap<>();

        Arrays.stream(Prize.values())
                .forEach(prize -> winningResult.put(prize, winningResult.getOrDefault(prize, 0)));

        return winningResult;
    }

}
