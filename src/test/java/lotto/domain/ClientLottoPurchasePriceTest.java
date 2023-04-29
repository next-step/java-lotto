package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientLottoPurchasePriceTest {

    private static final int MIN_PURCHASABLE_PRICE = 1000;

    @Test
    @DisplayName("로또 구매 금액 입력시 1000원 이상 입력할 경우 객체 정상 생성")
    void clientLottoPurchasePriceCreate() {
        assertDoesNotThrow(() -> new ClientLottoPurchasePrice(MIN_PURCHASABLE_PRICE));
    }
}
