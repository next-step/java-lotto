package lotto.step2.input;

import lotto.step2.service.LottoProgram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @ValueSource(ints = {999, 900, 0, -1000, -3000})
    @DisplayName("생성자로 1장의 로또 가격 미만의 구매 금액이 입력되면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenPurchaseAmountIsLessThanZeroAndIsEqualToZero(final int userPriceInput) {
        //given, when, then
        assertThatThrownBy(() -> new PurchaseAmount(userPriceInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("purchaseAmount must be greater than lotto's price");
    }

    @Test
    @DisplayName("생성자로 최대 구매 가능 금액 이상의 금액이 입력되면, IllegalArgumentException이 발생한다.")
    void throwIllegalArgumentExceptionWhenPurchaseAmountIsGreaterThanMaxValue() {
        //given, when, then
        assertThatThrownBy(() -> new PurchaseAmount(PurchaseAmount.MAX_VALUE + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("purchaseAmount must be less than or equal to" + PurchaseAmount.MAX_VALUE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 9000, 15000})
    @DisplayName("getMaxPassiveLottoCount 메서드를 사용하면, 최대 수동으로 구매 가능한 로또 수를 반환한다.")
    void testGetMaxPassiveLottoCount(final int userPriceInput) {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(userPriceInput);

        //when
        final int maxPassiveLottoCount = purchaseAmount.getMaxPassiveLottoCount();

        //then
        assertThat(maxPassiveLottoCount).isEqualTo(userPriceInput / LottoProgram.LOTTO_PRICE);
    }
}
