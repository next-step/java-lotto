package study.step3;

import study.step3.domain.LottoMachine;
import study.step3.domain.LottoTickets;
import study.step3.domain.LottoWinners;
import study.step3.view.InputView;
import study.step3.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int buyAmount = inputView.inputBuyAmount();

        LottoTickets lottoTickets = LottoMachine.createLottoTickets(buyAmount);

        ResultView resultView = new ResultView(lottoTickets);
        resultView.printLottoTicketInfos();

        String inputNumber = inputView.inputWinnerNumbers();
        int inputBonusNumber = inputView.inputBonusNumber();
        LottoWinners lottoWinners = LottoMachine.createWinners(inputNumber, inputBonusNumber);

        resultView.printLottoRanksInfos(lottoWinners);
        resultView.printLottoYield(lottoTickets, lottoWinners);

    }
}
