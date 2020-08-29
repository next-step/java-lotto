package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int paymentAmount = InputView.setPayPriceLotto(scanner);

        int manualLottoQuantity = InputView.setManualLottoQuantity(scanner);
        InputView.printManualLottoNumber(scanner);

        LottoService lottoService = new LottoService();
        List<String> manualLottoTicket = lottoService.setManualLottoNumbers(scanner, manualLottoQuantity);
        List<LottoTicket> manualLottoTickets = LottoNumberGenerator.generateManualLottoTickets(manualLottoTicket, manualLottoQuantity);

        int totalLottoQuantity = lottoService.getLottoBuyCount(paymentAmount);
        int autoLottoQuantity = lottoService.getAutoLottoBuyCount(manualLottoQuantity, totalLottoQuantity);
        InputView.printLottoBuyQuantity(manualLottoQuantity, autoLottoQuantity);

        List<LottoTicket> autoLottoTickets = LottoNumberGenerator.generateAutoLottoTickets(autoLottoQuantity);

        LottoTickets lottoTickets = LottoTickets.of(autoLottoTickets, manualLottoTickets);
        ResultView.printLottoTickets(lottoTickets);

        String inputWinningNumber = InputView.setWinningNumber(scanner);
        int bonusLottoNumber = InputView.setBonusLottoNumber(scanner);

        LottoTicket winningNumbers = LottoNumberGenerator.generateWinningNumber(inputWinningNumber);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusLottoNumber);

        Map<Rank, Long> winningResultMap = lottoTickets.matchResult(winningNumber);
        WinningResult winningResult = new WinningResult(winningResultMap);

        ResultView.printWinningNumericalStatement();
        ResultView.printLottoResult(winningResult);

        Profit profit = new Profit(winningResult);
        int result = profit.getWinningAmount();
        String rateOfReturn = profit.getRateOfReturn(paymentAmount, result);
        double baseValue = profit.getBaseValue(rateOfReturn);
        ResultView.printRateOfReturn(rateOfReturn, baseValue);
    }

}
