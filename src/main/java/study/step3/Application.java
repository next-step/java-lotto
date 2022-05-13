package study.step3;

import study.step3.domain.LottoMachine;
import study.step3.domain.LottoTickets;
import study.step3.domain.LottoWinners;
import study.step3.domain.strategy.LottoAuto;
import study.step3.view.InputView;
import study.step3.view.ResultView;

public class Application {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        int buyAmount = inputView.inputBuyAmount();

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
