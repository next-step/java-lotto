package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;
import java.util.Set;


public class LottoMain {

    public static void main(String[] args) {
        LottoTickets lottoTickets = createLottoTickets();
        ResultView.printLottoTickets(lottoTickets);

        Set<LottoNumber> winLottoNumbers = InputView.inputWinNumber();

        LottoGame lottoGame = new LottoGame(lottoTickets, winLottoNumbers);
        LottoResult lottoResult = lottoGame.playLotto();

        ResultView.printWinResult(lottoResult);
        ResultView.printWinRate(lottoResult, lottoTickets);
    }

    private static LottoTickets createLottoTickets() {
        String strLottoCost = InputView.inputLottoCost();
        Cost amoumt = new Cost(Integer.parseInt(strLottoCost));

        int ticketCount = amoumt.getLottoTicketCount();
        return LottoFactory.createAutoLottoTickets(ticketCount);
    }
}
