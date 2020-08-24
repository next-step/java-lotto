package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("돈")
public class MoneyTest {

    @DisplayName("몇장 구매하는지 계산")
    @ParameterizedTest
    @CsvSource(value = {"10000,10", "14000,14", "5000,5"})
    public void calculateLottoPurchaseCount(int amount, int lottoPurchaseCount) {
        Money money = new Money(amount);
        assertThat(money.calculateLottoPurchaseCount()).isEqualTo(lottoPurchaseCount);
    }

    @DisplayName("수익률 계산")
    @Test
    public void calculateYeild() {
        Money money = new Money(10000);
        assertThat(money.calculateYelid(5000)).isEqualTo(0.5);
    }

}
