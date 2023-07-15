package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuantityTest {
    @Test
    @DisplayName("구입 금액이 price의 배수일 때 Money와 price로부터 로또 개수 생성.")
    void quantityNoRemainderTest() {
        //when
        Quantity quantity = Quantity.of(new Money(10000), 1000);

        //then
        quantity.equals(new Quantity(10));
    }

    @Test
    @DisplayName("구입 금액이 price의 배수가 아닐 때 Money와 price로부터 로또 개수 생성.")
    void quantityExistRemainderTest() {
        //when
        Quantity quantity = Quantity.of(new Money(10100), 1000);

        //then
        quantity.equals(new Quantity(10));
    }

    @Test
    @DisplayName("수량이 0보다 작으면 에러 반환.")
    void quantityLessThanZeroThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity(-1));
    }

    @Test
    @DisplayName("수량 빼기 테스트")
    void subtractTest() {
        //given
        Quantity quantity1 = new Quantity(10);
        Quantity quantity2 = new Quantity(6);

        //when, then
        assertThat(quantity1.subtract(quantity2)).isEqualTo(new Quantity(4));

    }
}