package dev.dahye.lotto;

import dev.dahye.lotto.domain.Winning;
import dev.dahye.lotto.service.LottoService;
import dev.dahye.lotto.view.InputView;
import dev.dahye.lotto.view.ResultView;

import java.util.List;

public class LottoMachine {
    public static void main(String[] args) {
        int money = InputView.doInputMoney();

        LottoService lottoService = new LottoService(money);
        ResultView.buyLottoTickets(lottoService.getLottoTickets());

        String winningNumbers = InputView.doInputWinningNumbers();
        List<Winning> winnings = lottoService.getWinnings(winningNumbers);
        ResultView.printWinningStatistics(winnings);
        ResultView.printWinningRate(lottoService.getWinningRate(winnings));
    }
}
