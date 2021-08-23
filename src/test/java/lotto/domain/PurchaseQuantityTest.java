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

    @DisplayName("구매 수량이 0보다 작은 경우 예외가 발생한다.")
    @Test
    public void negativeInputTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseQuantity.of(-1))
                .withMessageContaining(String.valueOf(-1));
    }

    @ParameterizedTest(name = "구매 수량 뺄셈 테스트")
    @CsvSource(value = {"3,2,1", "3,0,3", "3,3,0"})
    public void subtractTest(int minuend, int subtrahend, int expected) {
        PurchaseQuantity minuendQuantity = PurchaseQuantity.of(minuend);
        PurchaseQuantity subtrahendQuantity = PurchaseQuantity.of(subtrahend);
        assertThat(minuendQuantity.subtract(subtrahendQuantity))
                .isEqualTo(PurchaseQuantity.of(expected));
    }

    @DisplayName("감수가 피감수보다 큰 경우 예외가 발생한다.")
    @Test
    public void subtractExceptionTest() {
        PurchaseQuantity minuendQuantity = PurchaseQuantity.of(1);
        PurchaseQuantity subtrahendQuantity = PurchaseQuantity.of(2);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> minuendQuantity.subtract(subtrahendQuantity))
                .withMessageContainingAll("1", "2");
    }
}