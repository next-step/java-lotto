package lotto.main;

import lotto.domain.LottoGameService;
import lotto.exception.TicketNumberOutOfBoundException;
import lotto.exception.TicketPriceOutOfBoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {
    LottoGameService lottoGameService;

    @BeforeEach
    void init() {
        lottoGameService = LottoGameService.from();
    }

    @Test
    @DisplayName("통합 테스트")
    void integrateTest() throws TicketNumberOutOfBoundException, TicketPriceOutOfBoundException {
        lottoGameService.buyTickets();
        lottoGameService.inputWinningNumber();
        lottoGameService.makeLotteryResult();
    }
}
