package lotto.domain;

import lotto.dto.BuyerData;
import lotto.dto.TicketData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {
    @DisplayName("티켓 구매자의 정보 데이터를 잘 가져오는지 확인")
    @Test
    void getBuyerData() {
        LottoBuyer buyer = new LottoBuyer(1, 0);

        assertEquals(
            buyer.getBuyerData(),
            new BuyerData(
            1,
                new ArrayList<TicketData>()
            )
        );
    }

    @DisplayName("자동 티켓을 개수대로 잘 구매하는지 확인")
    @Test
    void buyAutoTickets() {
        LottoBuyer buyer = new LottoBuyer(2, 0);

        buyer.buyAutoTickets();

        assertEquals(2, buyer.getBoughtTickets().size());
    }
}
