package dev.dahye.lotto;

import dev.dahye.lotto.domain.Winning;
import dev.dahye.lotto.service.LottoMachine;
import dev.dahye.lotto.view.InputView;
import dev.dahye.lotto.view.ResultView;

import java.util.List;

public class LottoPlay {
    public static void main(String[] args) {
        int money = InputView.doInputMoney();

        LottoMachine lottoMachine = new LottoMachine(money);
        ResultView.buyLottoTickets(lottoMachine.getLottoTickets());

        String winningNumbers = InputView.doInputWinningNumbers();
        List<Winning> winnings = lottoMachine.getWinnings(winningNumbers);
        ResultView.printWinningStatistics(winnings);
        ResultView.printWinningRate(lottoMachine.getWinningRate(winnings));
    }
}
