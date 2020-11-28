package lotto;

import lotto.domain.Calculator;
import lotto.domain.Generator;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.ProfitCalculator;
import lotto.domain.Scanner;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Calculator calculator = new Calculator();
        Generator generator = Generator.newGenerator();

        int tickets = calculator.calculateLottoTicket(inputView.inputPayment());
        resultView.printTickets(tickets);
        List<LottoTicket> lottoTickets = generator.generateLottoTickets(tickets);
        resultView.printLottoTickets(lottoTickets);
        Scanner scanner = new Scanner(inputView.inputWinningNumbers());
        LottoResult lottoResult = scanner.scanAll(lottoTickets);

        resultView.printLottoResult(lottoResult);

    }
}
