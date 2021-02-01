package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketBunchTest {
    @DisplayName("티켓 뭉치의 사이즈를 잘 가져오는지 확인")
    @Test
    void getSize() {
        LottoTicketBunch ticketBunch = new LottoTicketBunch(
            new ArrayList<LottoTicket>() {{
                add(LottoTicketGenerator.generateManualTicket("7, 8, 9, 10, 11, 12"));
                add(LottoTicketGenerator.generateManualTicket("1, 2, 3, 4, 5, 8"));
            }}
        );

        assertEquals(2, ticketBunch.getSize());
    }

    @DisplayName("두 티켓뭉치를 잘 합치는지 확인")
    @Test
    void merge() {
        List<LottoTicket> tickets1 = new ArrayList<LottoTicket>() {{
            add(LottoTicketGenerator.generateManualTicket("7, 8, 9, 10, 11, 12"));
            add(LottoTicketGenerator.generateManualTicket("1, 2, 3, 4, 5, 8"));
        }};
        List<LottoTicket> tickets2 = new ArrayList<LottoTicket>() {{
            add(LottoTicketGenerator.generateManualTicket("13, 14, 15, 16, 17, 18"));
        }};

        LottoTicketBunch ticketBunch1 = new LottoTicketBunch(tickets1);
        LottoTicketBunch ticketBunch2 = new LottoTicketBunch(tickets2);

        assertEquals(
            new LottoTicketBunch(
                new ArrayList<LottoTicket>() {{
                    add(LottoTicketGenerator.generateManualTicket("7, 8, 9, 10, 11, 12"));
                    add(LottoTicketGenerator.generateManualTicket("1, 2, 3, 4, 5, 8"));
                    add(LottoTicketGenerator.generateManualTicket("13, 14, 15, 16, 17, 18"));
                }}
            ),
            ticketBunch1.merge(ticketBunch2)
        );
    }

    @DisplayName("입력된 정답에 따른 스코어 보드를 잘 만들어내는지 확인")
    @Test
    void calcScoreBoard() {
        LottoTicketBunch ticketBunch = new LottoTicketBunch(
            new ArrayList<LottoTicket>() {{
                add(LottoTicketGenerator.generateManualTicket("7, 8, 9, 10, 11, 12"));
                add(LottoTicketGenerator.generateManualTicket("1, 2, 3, 4, 5, 8"));
                add(LottoTicketGenerator.generateManualTicket("1, 2, 3, 4, 5, 7"));
            }}
        );

        assertEquals(
            new LottoScoreBoard(
                new ArrayList<LottoScore>() {{
                    add(LottoScore.NOTHING);
                    add(LottoScore.SECOND);
                    add(LottoScore.THIRD);
                }}
            ),
            ticketBunch.calcScoreBoard(
                new LottoAnswer(
                    LottoTicketGenerator.generateManualTicket("1, 2, 3, 4, 5, 6"),
                    new LottoNumber(7)
                )
            )
        );
    }
}