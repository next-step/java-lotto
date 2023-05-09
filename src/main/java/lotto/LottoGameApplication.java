package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Matches;
import lotto.domain.LottoResult;
import lotto.dto.LottoTicketInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameApplication {

    public static void main(String[] args) {
        int price = InputView.getPriceFromUser();
        LottoTicket ticket = LottoMachine.buyTicket(price);
        ResultView.printLottoTicketInfo(LottoTicketInfo.from(ticket));

        String winNumber = InputView.getWinNumberFromUser();
        Lotto winningLotto = Lotto.from(winNumber);

        Matches matches = ticket.getMatches(winningLotto);
        LottoResult result = LottoResult.from(price, matches);

        ResultView.printLottoResult(result);
    }
}
