package study.step4;

import study.step4.domain.LottoMachine;
import study.step4.domain.LottoTickets;
import study.step4.domain.LottoWinners;
import study.step4.domain.strategy.LottoAuto;
import study.step4.view.InputView;
import study.step4.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int buyAmount = InputView.getInstance().inputBuyAmount();
        int manualLottoQuantity = InputView.getInstance().inputManualLottoQuantity(buyAmount);

        List<List<Integer>> inputManual = InputView.getInstance().inputManualLottoNumbers(manualLottoQuantity);

        LottoMachine lottoMachine = new LottoMachine(new LottoAuto());
        LottoTickets lottoTickets = lottoMachine.createLottoTickets(buyAmount, manualLottoQuantity);

        ResultView resultView = new ResultView(lottoTickets);
        resultView.printLottoTicketInfos(inputManual.size());

        String inputNumber = InputView.getInstance().inputWinnerNumbers();
        int inputBonusNumber = InputView.getInstance().inputBonusNumber();
        LottoWinners lottoWinners = LottoMachine.createWinners(inputNumber, inputBonusNumber);

        resultView.printLottoResultInfos(lottoTickets, lottoWinners);
    }
}
