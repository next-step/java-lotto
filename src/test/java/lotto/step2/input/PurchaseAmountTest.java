package lotto.step2.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 9000, 15000})
    @DisplayName("생성자로 정상적인 구매 금액이 입력되면, 생성된 객체는 구입금액을 가지고 있다.")
    void testPurchaseAmountConstructor(final int userPriceInput) {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(userPriceInput);

        //when
        final int value = purchaseAmount.getValue();

        //then
        assertThat(value).isEqualTo(userPriceInput);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000, -3000})
    @DisplayName("생성자로 0원 이하의 구매 금액이 입력되면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenPurchaseAmountIsLessThanZeroAndIsEqualToZero(final int userPriceInput) {
        //given, when, then
        assertThatThrownBy(() -> new PurchaseAmount(userPriceInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("purchaseAmount must be greater than 0");
    }
}
