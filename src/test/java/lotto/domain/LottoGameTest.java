package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @DisplayName("게임의 스코어 보드를 잘 만들어내는지 확인")
    @Test
    void calcScoreBoard() {
        LottoGame lottoGame = new LottoGame(
            new LottoAnswer(
                LottoTicketGenerator.generateManualTicket("1, 2, 3, 4, 5, 6"),
                new LottoNumber(7)
            ),
            new LottoTicketBunch(
                new ArrayList<LottoTicket>() {{
                    add(LottoTicketGenerator.generateManualTicket("7, 8, 9, 10, 11, 12"));
                    add(LottoTicketGenerator.generateManualTicket("1, 2, 3, 4, 5, 8"));
                    add(LottoTicketGenerator.generateManualTicket("1, 2, 3, 4, 5, 7"));
                }}
            )
        );

        assertEquals(
            new LottoScoreBoard(
                new ArrayList<LottoScore>() {{
                    add(LottoScore.NOTHING);
                    add(LottoScore.SECOND);
                    add(LottoScore.THIRD);
                }}
            ),
            lottoGame.calcScoreBoard()
        );
    }
}