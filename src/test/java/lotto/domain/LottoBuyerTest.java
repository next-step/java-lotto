package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {

    @DisplayName("입력한 숫자 만큼 티켓을 잘 구매하는지 확인")
    @Test
    void buyTickets() {
        LottoBuyer buyer = new LottoBuyer(3);
        assertEquals(3, buyer.BuyTickets().size());
    }
}