package lotto;

import lotto.domain.*;
import lotto.dto.LottoTicketInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Collections;

public class LottoGameApplication {

    public static void main(String[] args) {
        int price = InputView.getPriceFromUser();
        LottoGenerator lottoGenerator = new LottoGenerator(Collections::shuffle);
        LottoMachine lottoMachine = new LottoMachine(lottoGenerator);

        LottoTicket ticket = lottoMachine.buyTicket(price);
        ResultView.printLottoTicketInfo(LottoTicketInfo.from(ticket));

        String winNumber = InputView.getWinNumberFromUser();
        Lotto winningLotto = Lotto.from(winNumber);

        Matches matches = ticket.getMatches(winningLotto);
        LottoResult result = LottoResult.from(price, matches);

        ResultView.printLottoResult(result);
    }
}
