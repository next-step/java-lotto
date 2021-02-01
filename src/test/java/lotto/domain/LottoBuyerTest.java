package lotto.domain;

import lotto.dto.BuyData;
import lotto.dto.TicketData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {
    @DisplayName("수동 티켓의 구매가 남아있는지 여부를 잘 가져오는지 확인")
    @ParameterizedTest
    @CsvSource({
        "1, true",
        "0, false",
    })
    void shouldBuyManualTicket(int manualTicketCnt, boolean expected) {
        LottoBuyer buyer = new LottoBuyer(0, manualTicketCnt);

        assertEquals(expected, buyer.shouldBuyManualTicket());
    }

    @DisplayName("수동 티켓을 잘 구매하는지 확인")
    @Test
    void buyManualTicket() {
        LottoBuyer buyer = new LottoBuyer(0, 1);

        buyer.buyManualTicket("1, 2, 3, 4, 5, 6");

        assertEquals(
            new LottoTicketBunch(
                Arrays.asList(
                    new LottoTicket(
                        Arrays.asList(
                            new LottoNumber(1),
                            new LottoNumber(2),
                            new LottoNumber(3),
                            new LottoNumber(4),
                            new LottoNumber(5),
                            new LottoNumber(6)
                        )
                    )
                )
            ),
            buyer.getBoughtTickets()
        );
    }

    @DisplayName("자동 티켓을 개수대로 잘 구매하는지 확인")
    @Test
    void buyAutoTickets() {
        LottoBuyer buyer = new LottoBuyer(2, 0);

        buyer.buyAutoTickets();

        assertEquals(2, buyer.getBoughtTickets().getSize());
    }

    @DisplayName("구매 정보를 잘 가져오는지 확인")
    @Test
    void getBuyData() {
        LottoBuyer buyer = new LottoBuyer(1, 0);

        assertEquals(
            buyer.getBuyData(),
            new BuyData(
                0,
                0,
                new ArrayList<TicketData>()
            )
        );
    }
}
