package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoGame {

    public static void main(String[] args) {
        int paymentAmount = InputView.setPayPriceLotto();

        int manualLottoQuantity = InputView.setManualLottoQuantity();
        InputView.printManualLottoNumber();

        LottoService lottoService = new LottoService();
        List<String> manualLottoTicket = lottoService.setManualLottoNumbers(manualLottoQuantity);
        List<LottoTicket> manualLottoTickets = LottoNumberGenerator.generateManualLottoTickets(manualLottoTicket, manualLottoQuantity);

        int totalLottoQuantity = lottoService.getLottoBuyCount(paymentAmount);
        int autoLottoQuantity = lottoService.getAutoLottoBuyCount(manualLottoQuantity, totalLottoQuantity);
        InputView.printLottoBuyQuantity(manualLottoQuantity, autoLottoQuantity);

        List<LottoTicket> autoLottoTickets = LottoNumberGenerator.generateAutoLottoTickets(autoLottoQuantity);

        LottoTickets lottoTickets = LottoTickets.of(autoLottoTickets, manualLottoTickets);
        ResultView.printLottoTickets(lottoTickets);

        String inputWinningNumber = InputView.setWinningNumber();
        int bonusNumber = InputView.setBonusLottoNumber();

        LottoTicket winningNumbers = LottoNumberGenerator.generateWinningNumber(inputWinningNumber);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);

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
