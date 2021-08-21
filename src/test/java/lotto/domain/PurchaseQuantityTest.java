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
                .isThrownBy(() -> PurchaseQuantity.of(Money.of(amount)))
                .withMessageContaining(String.valueOf(amount));
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

    @ParameterizedTest(name = "구매 수량 간 뺄셈이 가능하다.")
    @CsvSource(value = {"3,1,2", "1,1,0", "0,0,0"})
    public void subtractTest(int totalQuantity, int manualQuantity, int automaticQuantity) {
        PurchaseQuantity totalPurchaseQuantity = PurchaseQuantity.of(totalQuantity);
        PurchaseQuantity manualPurchaseQuantity = PurchaseQuantity.of(manualQuantity);
        assertThat(totalPurchaseQuantity.subtract(manualPurchaseQuantity))
                .isEqualTo(PurchaseQuantity.of(automaticQuantity));
    }

    @DisplayName("구매 수량이 0보다 작은 경우 예외가 발생한다.")
    @Test
    public void negativeInputTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseQuantity.of(-1))
                .withMessageContaining(String.valueOf(-1));
    }
}