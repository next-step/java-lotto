package lotto.domain;

import lotto.dto.BuyData;
import lotto.dto.TicketData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {
    @DisplayName("수동 티켓을 잘 구매하는지 확인")
    @Test
    void buyManualTicketBunch() {
        LottoBuyer buyer = new LottoBuyer(0, 1);

        buyer.buyManualTicketBunch(
            () -> "1, 2, 3, 4, 5, 6"
        );

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
            buyer.getBoughtTicketBunch()
        );
        assertEquals(1, buyer.getBoughtTicketBunch().getSize());
    }

    @DisplayName("자동 티켓을 잘 구매하는지 확인")
    @Test
    void buyAutoTicketBunch() {
        LottoBuyer buyer = new LottoBuyer(2, 0);

        buyer.buyAutoTicketBunch();

        assertEquals(2, buyer.getBoughtTicketBunch().getSize());
    }

    @DisplayName("구매한 로또 티켓 뭉치를 잘 가져오는지 확인")
    @Test
    void getBoughtTicketBunch() {
        LottoBuyer buyer = new LottoBuyer(3, 4);

        buyer.buyManualTicketBunch(
            () -> "1, 2, 3, 4, 5, 6"
        );
        buyer.buyAutoTicketBunch();

        assertEquals(7, buyer.getBoughtTicketBunch().getSize());
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
