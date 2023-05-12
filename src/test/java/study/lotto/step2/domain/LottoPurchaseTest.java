package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class LottoPurchaseTest {
    @Test
    @DisplayName("로또 장당 금액(1,000)보다 작은 금액으로 판매 시, IllegalArgumentException 예외 발생")
    void less_than_lotto_price_then_throw_IllegalArgumentException() {
        // given
        long invalidPurchaseAmount = 999L;

        // when, then
        assertThatThrownBy(() -> new LottoPurchase(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구입 금액은 1000원입니다: " + invalidPurchaseAmount);
    }

    @Test
    @DisplayName("로또 구매 갯수")
    void purchase_size() {
        // given
        LottoPurchase lottoPurchase = new LottoPurchase(4_999L);

        // when
        long purchaseSize = lottoPurchase.purchaseSize();

        // then
        assertThat(purchaseSize).isEqualTo(4);
    }

    @ParameterizedTest(name = "[{index}/4] {displayName}")
    @NullAndEmptySource
    @CsvSource(value = {"-1000", "one thousand won"})
    @DisplayName("문자열 타입의 구입 금액이 양의 정수가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_String_purchase_amount(String invalidAmount) {
        assertThatThrownBy(() -> new LottoPurchase(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 양의 정수로 입력해야 합니다: " + invalidAmount);
    }
}