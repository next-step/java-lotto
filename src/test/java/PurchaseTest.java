import Lotto.domain.Purchase;
import Lotto.validation.Validations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"14000", "14,000", "1000"})
    void should_be_valid_price(String input) {
        assertFalse(Validations.isInvalidPrice(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "", " ", "14501"})
    void should_be_invalid_price(String input) {
        assertTrue(Validations.isInvalidPrice(input));
    }

    @Test
    void should_buy_right_amount_of_lotto() {
        int price = 14000;
        Purchase purchase = new Purchase(price);
        assertEquals(14, purchase.getQuantity(), "로또 구매 개수는 금액에 비례해야 합니다.");
    }
}
