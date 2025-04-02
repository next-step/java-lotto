import Lotto.domain.Purchase;
import Lotto.validation.Validations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"14000", "14500", "14,000", "1000", "-1000", "", " "})
    void should_be_valid_price(String input) {
        boolean result = Validations.isInvalidPrice(input);

        if (input.equals("14000") || input.equals("1000") || input.equals("14,000")) {
            assertFalse(result);
        } else {
            assertTrue(result);
        }
    }

    @Test
    void should_buy_right_amount_of_lotto() {
        int price = 14000;
        Purchase purchase = new Purchase(price);
        assertEquals(14, purchase.getQuantity(), "로또 구매 개수는 금액에 비례해야 합니다.");
    }
}
