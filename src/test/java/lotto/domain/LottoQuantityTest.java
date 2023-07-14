package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoQuantityTest {
    @Test
    @DisplayName("구입 금액이 price의 배수일 때 Money와 price로부터 로또 개수 생성")
    void quantityNoRemainderTest() {
        //when
        LottoQuantity quantity = LottoQuantity.of(new Money(10000), 1000);

        //then
        quantity.equals(new LottoQuantity(10));
    }

    @Test
    @DisplayName("구입 금액이 price의 배수가 아닐 때 Money와 price로부터 로또 개수 생성")
    void quantityExistRemainderTest() {
        //when
        LottoQuantity quantity = LottoQuantity.of(new Money(10100), 1000);

        //then
        quantity.equals(new LottoQuantity(10));
    }
}