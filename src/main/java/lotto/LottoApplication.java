package lotto;

import lotto.domain.Calculator;
import lotto.domain.Generator;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningCondition;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Calculator calculator = new Calculator();
        Generator generator = new Generator();

        int lottoTicketCount = calculator.calculateLottoTicketCount(inputView.inputPayment());
        int manualLottoCount = inputView.inputManualLottoCount();
        int autoLottoTicketCount = calculator.getAutoLottoCount(lottoTicketCount, manualLottoCount);

        List<List<Integer>> manualLottoNumbers = inputView.inputManualLottoNumbers(manualLottoCount);
        List<LottoTicket> manualLottoTickets = generator.generateManualLottoTicket(manualLottoNumbers);

        resultView.printTickets(manualLottoCount, autoLottoTicketCount);
        List<LottoTicket> autoLottoTickets = generator.generateLottoTickets(autoLottoTicketCount);
        autoLottoTickets.addAll(manualLottoTickets);
        resultView.printLottoTickets(autoLottoTickets);

        WinningCondition winningCondition = WinningCondition.of(inputView.inputWinningNumbers(), inputView.inputBonusNumber());
        LottoResult lottoResult = LottoResult.getLottoResult(autoLottoTickets, winningCondition);
        resultView.printLottoResult(lottoResult);
    }
}
