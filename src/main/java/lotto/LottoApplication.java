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

        int ticketCount = calculator.calculateLottoTicket(inputView.inputPayment());
        resultView.printTickets(ticketCount);
        List<LottoTicket> lottoTickets = generator.generateLottoTickets(ticketCount);
        resultView.printLottoTickets(lottoTickets);

        Scanner scanner = new Scanner(inputView.inputWinningNumbers());
        LottoResult lottoResult = scanner.scanAll(lottoTickets);
        resultView.printLottoResult(lottoResult);
    }
}
