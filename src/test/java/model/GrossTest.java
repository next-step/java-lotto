package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrossTest {
    @Test
    @DisplayName("수익률 테스트")
    void grossTest() {
        //given
        int totalPrice = 5000;
        int totalMoney = 14000;

        // when
        Gross gross = new Gross(totalPrice, totalMoney);

        //then
        double expected = 0.36;

        assertEquals(expected, gross.getGross());

    }
}
