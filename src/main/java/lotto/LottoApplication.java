package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinnerLottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Integer input = inputView.inputLottoMoney();

        Lotto lotto = new Lotto();
        List<LottoTicket> lottoTickets = lotto.buyLottoTicket(input);

        OutputView outputView = new OutputView();
        outputView.printLottoTicket(lottoTickets);
        String inputLottoWinnerNumber = inputView.inputLottoWinnerNumber();
        WinnerLottoTicket lottoTicket = new WinnerLottoTicket(inputLottoWinnerNumber);

        outputView.printLottoResult(lottoTicket, lottoTickets);


    }

}
