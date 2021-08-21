package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseQuantityTest {

    @ParameterizedTest(name = "구매 금액은 1000으로 나누어 떨어지는 양의 정수가 아닌 경우 예외가 발생한다.")
    @ValueSource(ints = {-1000, 14500})
    public void purchaseFailTest(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseQuantity.withAutomatic(Money.of(amount), PurchaseQuantity.of(1)))
                .withMessageContaining(String.valueOf(amount));
    }

    @ParameterizedTest(name = "구매 금액이 null 인 경우 예외가 발생한다.")
    @NullSource
    public void nullSourceExceptionTest(Money money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseQuantity.withAutomatic(money, PurchaseQuantity.of(1)))
                .withMessageContaining("null");
    }

    @DisplayName("구매 수량이 0보다 작은 경우 예외가 발생한다.")
    @Test
    public void negativeInputTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseQuantity.of(-1))
                .withMessageContaining(String.valueOf(-1));
    }

    @ParameterizedTest(name = "구매 금액과 수동 구매 수량으로 자동 구매 수량을 알 수 있다.")
    @CsvSource(value = {"3000,1,2", "3000,0,3", "3000,3,0"})
    public void automaticPurchaseQuantityTest(int amount, int manual, int automatic) {
        PurchaseQuantity automaticPurchaseQuantity = PurchaseQuantity.withAutomatic(Money.of(amount), PurchaseQuantity.of(manual));
        assertThat(automaticPurchaseQuantity).isEqualTo(PurchaseQuantity.of(automatic));
    }
}