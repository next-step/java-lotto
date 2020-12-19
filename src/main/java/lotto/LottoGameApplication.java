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

        int countOfManualLottoTicket = InputView.enterManualLottoCount();
        LottoTickets manualLottoTickets = new LottoTickets(InputView.enterManualLottoNumbers(countOfManualLottoTicket));

        LottoMachine lottoMachine = new LottoMachine(money.getCountOfAutoLotto(countOfManualLottoTicket));
        LottoTickets autoLottoTickets = lottoMachine.makeAutoLottoTickets();
        OutputView.printLottoTickets(manualLottoTickets, autoLottoTickets);

        LottoGame lottoGame = new LottoGame(manualLottoTickets, autoLottoTickets);
        WinningLottoTicket winningLottoTicket = makeWinningLottoTicket();
        LottoResult lottoResult = lottoGame.matchNumbers(winningLottoTicket);
        OutputView.printResults(lottoResult, money);
    }

    private static WinningLottoTicket makeWinningLottoTicket() {
        LottoTicket winningLottoTicket = new LottoTicket(InputView.enterWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.enterBonusBall());
        return new WinningLottoTicket(winningLottoTicket, bonusNumber);
    }
}
