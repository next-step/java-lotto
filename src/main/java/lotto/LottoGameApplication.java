package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameApplication {
    public static void main(String[] args) {
        long money = InputView.enterMoney();
        LottoMachine lottoMachine = new LottoMachine(money);
        LottoTickets lottoTickets = lottoMachine.makeLottoTickets();
        OutputView.printLottoTickets(lottoTickets.getLottoTickets());

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(InputView.enterWinningNumbers());

    }
}
