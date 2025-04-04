package domain;


import ui.OutputView;
import ui.InputView;
import ui.StringCalculator;

import java.util.List;


public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {

//        StringCalculator calculator = new StringCalculator(new InputView(), new OutputView());
//        calculator.run();

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        int purchaseAmount = inputView.getPurchaseAmount();
        List<LottoTicket> tickets = lottoService.generateLottoTickets(purchaseAmount / LOTTO_PRICE);
        outputView.printLottoTickets(tickets);

        List<Integer> winningNumbers = inputView.getWinningNumbers();
        LottoResult result = lottoService.calculateResults(tickets, winningNumbers);
        outputView.printResult(result);

    }
}
