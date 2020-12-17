package lotto;

import lotto.domain.*;
import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTicket;
import lotto.domain.numbers.LottoTickets;
import lotto.domain.numbers.WinningLottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameApplication {
    public static void main(String[] args) {
        Money money = new Money(InputView.enterMoney());

        LottoMachine lottoMachine = new LottoMachine(money.computeLottoTickets());
        LottoTickets lottoTickets = lottoMachine.makeLottoTickets();
        OutputView.printLottoTickets(lottoTickets);

        LottoGame lottoGame = new LottoGame(lottoTickets);
        WinningLottoTicket winningLottoTicket = makeWinningLottoTicket();
        LottoResult lottoResult = lottoGame.matchNumbers(winningLottoTicket);
        OutputView.printResults(lottoResult, money);
    }

    private static WinningLottoTicket makeWinningLottoTicket() {
        LottoTicket winningLottoTicket = new LottoTicket(InputView.enterWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.enterBonusBall());
        return new WinningLottoTicket(winningLottoTicket, bonusNumber);
    }
}
