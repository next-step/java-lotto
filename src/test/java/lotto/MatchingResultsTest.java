package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class MatchingResultsTest {
    @Test
    @DisplayName("총 상금 액수 구하기")
    public void totalPrizeMoney() {
        BigDecimal amount = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) {
            amount = amount.add(new BigDecimal(1000));
        }
        assertThat(amount).isEqualTo(new BigDecimal(10000));
    }

    @ParameterizedTest
    @CsvSource(value = {"15000,5000,0.34", "1000,2000000000,2000000"})
    @DisplayName("수익률 구하기")
    public void getProfit(Integer inputMoney, Integer totalPrizeMoney, double expectedRate) {
        BigDecimal prizeMoney = new BigDecimal(totalPrizeMoney);
        BigDecimal money = new BigDecimal(inputMoney);
        BigDecimal result = prizeMoney.divide(money, 2, BigDecimal.ROUND_CEILING);
        //Then
        assertThat(result.doubleValue()).isEqualTo(expectedRate);
    }
}