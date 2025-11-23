package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

    @Test
    @DisplayName("당첨금 합계를 계산한다.")
    void getPrizeValue() {
        assertThat(new LottoResults(1, 1, 1,1).getPrizeValue())
                .isEqualTo(2001555000L);
        assertThat(new LottoResults(0, 1, 1,4).getPrizeValue())
                .isEqualTo(8001550000L);
    }

    @ParameterizedTest
    @DisplayName("당첨금과 구매 금액을 통해 수익률을 계산한다.")
    @CsvSource({"0,0,0,0,0", "1,0,0,0,0.35", "0,0,0,1,142857.14"})
    void getReturnRate(int countOfFirst, int countOfSecond, int countOfThird, int countOfFourth, double expectedRate) {
        LottoResults results = new LottoResults(countOfFirst, countOfSecond, countOfThird, countOfFourth);
        assertThat(results.getReturnRate(new Budget(14000))).isEqualTo(expectedRate);
    }
}