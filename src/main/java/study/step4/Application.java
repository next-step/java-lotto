package study.step4;

import study.step4.domain.LottoMachine;
import study.step4.domain.LottoTickets;
import study.step4.domain.LottoWinners;
import study.step4.domain.strategy.LottoAuto;
import study.step4.view.InputView;
import study.step4.view.ResultView;

public class Application {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        int buyAmount = inputView.inputBuyAmount();
        int manualLottoQuantity = inputView.inputManualLottoQuantity(buyAmount);

        LottoMachine lottoMachine = new LottoMachine(new LottoAuto());
        LottoTickets lottoTickets = lottoMachine.createLottoTickets(buyAmount);

        ResultView resultView = new ResultView(lottoTickets);
        resultView.printLottoTicketInfos();

        String inputNumber = inputView.inputWinnerNumbers();
        int inputBonusNumber = inputView.inputBonusNumber();
        LottoWinners lottoWinners = LottoMachine.createWinners(inputNumber, inputBonusNumber);

        resultView.printLottoResultInfos(lottoTickets, lottoWinners);
    }
}
