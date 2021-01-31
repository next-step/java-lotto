package lotto.domain;

import lotto.dto.BuyerData;
import lotto.dto.TicketData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {

    @DisplayName("가지고 있는 자동 티켓 개수에 따라서 구매 여부를 잘 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({
        "1, true",
        "0, false",
    })
    void canBuyAutoTicket(int ticketCnt, boolean buyStatus) {
        LottoBuyer buyer = new LottoBuyer(ticketCnt);
        assertEquals(buyer.canBuyAutoTicket(), buyStatus);
    }

    @DisplayName("마지막 자동 티켓 구매 후, 구매가 불가능 해지는지 확인")
    @Test
    void buyAutoTicket() {
        LottoBuyer buyer = new LottoBuyer(1);

        buyer.buyAutoTicket();

        assertEquals(buyer.canBuyAutoTicket(), false);
    }

    @DisplayName("티켓 구매자의 정보 데이터를 잘 가져오는지 확인")
    @Test
    void getBuyerData() {
        LottoBuyer buyer = new LottoBuyer(1);

        assertEquals(
            buyer.getBuyerData(),
            new BuyerData(
            1,
                new ArrayList<TicketData>()
            )
        );
    }
}
