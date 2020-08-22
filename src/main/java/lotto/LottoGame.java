package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int paymentAmount = InputView.setPayPriceLotto(scanner);

        LottoService lottoService = new LottoService();
        int lottoTicketQuantity = lottoService.buyLottoTicket(paymentAmount);
        InputView.printLottoBuyQuantity(lottoTicketQuantity);

        LottoTickets lottoTickets = new LottoTickets(lottoTicketQuantity);
        InputView.printLottoTickets(lottoTickets);

        String inputWinningNumber = InputView.setWinningNumber(scanner);
        WinningNumber winningNumber = new WinningNumber();
        List<Integer> winningNumbers = winningNumber.setWinningNumber(inputWinningNumber);

        WinningResult winningResult = new WinningResult().matchWinningNumber(winningNumber, winningNumbers, lottoTickets);
        ResultView.printWinningNumericalStatement();
        ResultView.printLottoResult(winningResult);

        Profit profit = new Profit();
        int result = profit.checkWinningAmount(winningResult);
        String rateOfReturn = profit.getRateOfReturn(paymentAmount, result);
        double baseValue = new Profit(rateOfReturn).getBaseValue();
        ResultView.printRateOfReturn(rateOfReturn, baseValue);
    }
}
