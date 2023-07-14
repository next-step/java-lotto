package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoQuantityTest {
    @Test
    @DisplayName("Money를 바탕으로 ")
    void quantityOfMoneyAndManualQuantityTest() {
        //when
        LottoQuantity quantity = LottoQuantity.of(new Money(10000), 1000);

        //then
        quantity.equals(new LottoQuantity(10));
    }
}