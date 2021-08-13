package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseQuantityTest {

    @DisplayName("구매 금액은 1000으로 나누어 떨어지는 양의 정수가 아닌 경우 예외가 발생한다.")
    @Test
    public void purchaseFailTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseQuantity.of(Money.of(1500)))
                .withMessageContaining(String.valueOf(1500));
    }

    @ParameterizedTest(name = "구매 금액이 null 인 경우 예외가 발생한다.")
    @NullSource
    public void nullSourceExceptionTest(Money money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseQuantity.of(money))
                .withMessageContaining("null");
    }

    @ParameterizedTest(name = "구매한 로또 수량을 반환한다.")
    @CsvSource(value = {"0,0", "14000,14"})
    public void quantityTest(int moneyAmount, int expectedQuantity) {
        PurchaseQuantity purchaseQuantity = PurchaseQuantity.of(Money.of(moneyAmount));
        assertThat(purchaseQuantity.getQuantity())
                .isEqualTo(expectedQuantity);
    }

}