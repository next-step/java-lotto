package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int number = InputView.priceView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.generateLottoTicket(number);
        ResultView.lottoTicketView(lottoTicket);
    }
}
