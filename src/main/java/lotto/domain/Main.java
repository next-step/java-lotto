package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String [] args) {
        Lotto lotto = new Lotto();
        int purchaseAmount = InputView.inputPurchaseAmount();
        int manualTicketCount = InputView.inputManualLottoCount();

        Money money = new Money(purchaseAmount, manualTicketCount);

        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        List<Ticket> autoTickets = autoLottoGenerator.generate();

        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(InputView.inputManualLottoNumbers(manualTicketCount));
        List<Ticket> manualTickets = manualLottoGenerator.generate();

        lotto.addTickets(manualTickets);
        lotto.addTickets(autoTickets);

        ResultView.printLottoTicketCount(money);
        ResultView.printTickets(lotto.findLottos());

        LottoMachine lottoMachine = new LottoMachine(lotto);
        GameResult gameResult = lottoMachine.playLotto(InputView.inputLastWeeksWinningNumbers(), new LottoNo(InputView.inputBonusNumber()));

        ResultView.printLottoResults(gameResult);
    }
}
