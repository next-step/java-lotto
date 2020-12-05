package lotto;

import lotto.domain.Calculator;
import lotto.domain.Generator;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Scanner;
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

        inputView.inputManualLottoNumbers(manualLottoCount);

        resultView.printTickets(lottoTicketCount);
        List<LottoTicket> lottoTickets = generator.generateLottoTickets(lottoTicketCount);
        resultView.printLottoTickets(lottoTickets);

        Scanner.newScanner(inputView.inputWinningNumbers(), inputView.inputBonusNumber());
        LottoResult lottoResult = LottoResult.getLottoResult(lottoTickets);
        resultView.printLottoResult(lottoResult);
    }
}
