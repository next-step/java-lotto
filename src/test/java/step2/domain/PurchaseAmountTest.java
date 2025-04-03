package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchaseAmountTest {

    @DisplayName("수익률 계산 테스트")
    @CsvSource({"1000, 1000", "2000, 500", "4000, 3000"})
    @ParameterizedTest
    void getWinningRate(int inputAmount, int winningAmount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);

        // when
        double winningRate = purchaseAmount.getWinningRate(winningAmount);

        // then
        double actual = (double) winningAmount / inputAmount;
        Assertions.assertThat(actual).isEqualTo(winningRate);
    }
}
