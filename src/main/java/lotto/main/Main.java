package lotto.main;

import lotto.domain.LottoGameService;
import lotto.exception.TicketNumberOutOfBoundException;
import lotto.exception.TicketPriceOutOfBoundException;

public class Main {
    public static void main(String[] args) throws TicketNumberOutOfBoundException, TicketPriceOutOfBoundException {
        LottoGameService lottoGameService = LottoGameService.from();
        lottoGameService.buyTickets();
        lottoGameService.inputWinningNumber();
        lottoGameService.makeLotteryResult();
    }
}
