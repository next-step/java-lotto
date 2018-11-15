package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String [] args) {
        Lotto lotto = new Lotto();
        int purchaseAmount = InputView.inputPurchaseAmount();
        int manualTicketCount = InputView.inputManualLottoCount();

        Money money = new Money(purchaseAmount, manualTicketCount);

        LottoGenerator.generateLotto(lotto, InputView.inputManualLottoNumbers(manualTicketCount));

        ResultView.printLottoTicketCount(money);
        ResultView.printTickets(lotto.findLottos());

        LottoMachine lottoMachine = new LottoMachine(lotto);
        GameResult gameResult = lottoMachine.playLotto(InputView.inputLastWeeksWinningNumbers(), LottoNo.getInstance(InputView.inputBonusNumber()));

        ResultView.printLottoResults(gameResult);
    }
}
