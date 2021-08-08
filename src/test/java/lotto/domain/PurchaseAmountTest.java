package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseAmountTest {

    @ParameterizedTest(name = "구매 금액은 1000으로 나누어 떨어지는 양의 정수가 아닌 경우 예외가 발생한다.")
    @ValueSource(ints = {-1000, 1500})
    public void purchaseFailTest(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseAmount.of(amount))
                .withMessageContaining(String.valueOf(amount));
    }

}