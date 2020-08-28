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
        int lottoTicketQuantity = lottoService.getLottoBuyCount(paymentAmount);
        InputView.printLottoBuyQuantity(lottoTicketQuantity);

        List<LottoTicket> lottoTickets = LottoNumberGenerator.generateLottoTickets(lottoTicketQuantity);
        LottoTickets lottoStore = new LottoTickets(lottoTickets);
        InputView.printLottoTickets(lottoStore);

        String inputWinningNumber = InputView.setWinningNumber(scanner);
        int bonusLottoNumber = InputView.setBonusLottoNumber(scanner);

        LottoTicket winningNumbers = LottoNumberGenerator.generateWinningNumber(inputWinningNumber);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusLottoNumber);

        WinningResult winningResult = lottoStore.matchResult(winningNumber);
        ResultView.printWinningNumericalStatement();
        ResultView.printLottoResult(winningResult);

        Profit profit = new Profit(winningResult);
        int result = profit.getWinningAmount();
        String rateOfReturn = profit.getRateOfReturn(paymentAmount, result);
        double baseValue = profit.getBaseValue(rateOfReturn);
        ResultView.printRateOfReturn(rateOfReturn, baseValue);
    }

}
