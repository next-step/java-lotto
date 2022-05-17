package study.step4;

import study.step4.domain.LottoMachine;
import study.step4.domain.LottoTickets;
import study.step4.domain.LottoWinners;
import study.step4.domain.strategy.LottoAutoCreationStrategy;
import study.step4.view.InputView;
import study.step4.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView instance = InputView.getInstance();

        int buyAmount = instance.inputBuyAmount();
        int manualLottoQuantity = instance.inputManualLottoQuantity();

        List<List<Integer>> inputManual = instance.inputManualLottoNumbers(manualLottoQuantity);

        LottoMachine lottoMachine = new LottoMachine(new LottoAutoCreationStrategy());
        LottoTickets lottoTickets = lottoMachine.createLottoTickets(buyAmount, inputManual);

        ResultView resultView = new ResultView(lottoTickets);
        resultView.printLottoTicketInfos(inputManual.size());

        String inputNumber = instance.inputWinnerNumbers();
        int inputBonusNumber = instance.inputBonusNumber();
        LottoWinners lottoWinners = LottoMachine.createWinners(inputNumber, inputBonusNumber);

        resultView.printLottoResultInfos(lottoTickets, lottoWinners);
    }
}
