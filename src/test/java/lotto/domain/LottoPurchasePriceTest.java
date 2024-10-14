package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchasePriceTest {

    @ParameterizedTest
    @ValueSource(ints = {10100, 1200, 2200})
    @DisplayName("로또 구매 가격 / 로또 장당 가격이 나누어 떨어지지 않을 때 예외가 발생한다.")
    void throwExceptionWhenPriceNotDivisibleByTicketPrice(int purchasePrice) {
        assertThatThrownBy(() -> LottoPurchasePrice.valueOf(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0})
    @DisplayName("LottoPurchasePrice가 0이하의 수로 초기화 되었을 때 예외가 발생한다.")
    void throwExceptionWhenNegativePrice(int purchasePrice) {
        assertThatThrownBy(() -> LottoPurchasePrice.valueOf(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 0이거나 음수일 수 없습니다.");
    }

    @Test
    @DisplayName("LottoPurchasePrice 객체가 동등성을 보장한다.")
    void equalsTest() {
        LottoPurchasePrice price1 = LottoPurchasePrice.valueOf(1000);
        LottoPurchasePrice price2 = LottoPurchasePrice.valueOf(1000);
        assertThat(price1).isEqualTo(price2);
    }

    @Test
    @DisplayName("getAutoLottoCount 메서드가 총 개수에서 수동 복권 발급 개수을 제외한 자동 복권 발급 개수를 반환한다.")
    void getAutoLottoCountTest() {
        LottoPurchasePrice price = LottoPurchasePrice.valueOf(10000);
        int manualLottoCount = 3;
        assertThat(price.getAutoLottoCount(manualLottoCount))
                .isEqualTo(7);
    }
}