package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientLottoPurchasePriceTest {

    private static final int MIN_PURCHASABLE_PRICE = 1000;

    private static final int LOWER_THAN_MIN_PURCHASABLE_PRICE = 999;

    @Test
    @DisplayName("로또 구매 금액 입력시 1000원 이상 입력할 경우 객체 정상 생성")
    void clientLottoPurchasePriceCreate() {
        assertDoesNotThrow(() -> new ClientLottoPurchasePrice(MIN_PURCHASABLE_PRICE));
    }

    @Test
    @DisplayName("로또 구매 금액 입력시 1000원 이하 입력할 경우 익셉션 발생")
    void clientLottoPurchasePriceError() {
        assertThatThrownBy(() -> new ClientLottoPurchasePrice(LOWER_THAN_MIN_PURCHASABLE_PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 최소 구매 금액은 1000원 이상입니다.");
    }
}
