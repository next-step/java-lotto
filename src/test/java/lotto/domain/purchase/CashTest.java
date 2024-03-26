package lotto.domain.purchase;

import lotto.domain.purchase.Amount;
import lotto.domain.purchase.Cash;
import lotto.error.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CashTest {

    @DisplayName("Cash는 음수를 값으로 가질 수 없다.")
    @Test
    void constructor() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cash(-1))
                .withMessage(ErrorCode.CASH_CANNOT_BE_NEGATIVE.message());
    }

    @DisplayName("buyableAmount는 제품 금액에 따른 구매 가능 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "800,0", "1000,1", "3400,3"})
    void buyableAmount(int cash, int expectAmount) {
        assertThat(new Cash(cash).buyableAmount(new Cash(1000)))
                .isEqualTo(new Amount(expectAmount));
    }

    @DisplayName("buyableAmount에 매개변수로 넘기는 제품 금액은 음수나 0이 될 수 없다.")
    @Test
    void buyableAmount() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cash(1000).buyableAmount(new Cash(0)))
                .withMessage(ErrorCode.CASH_PRICE_CANNOT_BE_BELOW_ZERO.message());
    }

    @DisplayName("equalsZero는 Cash의 값이 0인지 검사한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,false", "0,true"})
    void equalsZero(long value, boolean expectResult) {
        assertThat(new Cash(value).equalsZero())
                .isEqualTo(expectResult);
    }

    @DisplayName("smallerThan은 매개변수로 넘긴 Cash보다 작은 값인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,true", "2,1,false", "1,1,false"})
    void smallerThan(long origin, long target, boolean expectResult) {
        assertThat(new Cash(origin).smallerThan(new Cash(target)))
                .isEqualTo(expectResult);
    }

    @DisplayName("multiply는 매개변수로 넘긴 수량을 금액에 곱한 Cash를 반환한다.")
    @Test
    void multiply() {
        assertThat(new Cash(10).multiply(new Amount(10)))
                .isEqualTo(new Cash(100));
    }

    @DisplayName("subtract는")
    @Nested
    class Describe_subtract {

        @DisplayName("매개변수로 넘긴 금액을 현재 금액에서 차감하여 반환한다.")
        @Test
        void success() {
            assertThat(new Cash(100).subtract(new Cash(10)))
                    .isEqualTo(new Cash(90));
        }

        @DisplayName("현재 금액보다 차감하고자 하는 금액이 큰 경우 IllegalArgumentException을 던진다.")
        @Test
        void target_value_bigger() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cash(1).subtract(new Cash(20)))
                    .withMessage(ErrorCode.CASH_CANNOT_BE_NEGATIVE.message());
        }

    }

}
