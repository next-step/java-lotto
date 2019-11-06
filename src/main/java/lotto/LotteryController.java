package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

/**
 * Created by yusik on 2019/11/05.
 */
public class LotteryController {

    private final LotteryGenerator lotteryGenerator;
    private final InputView inputView;
    private final ResultView resultView;

    public LotteryController(InputStream in, PrintStream out) {
        lotteryGenerator = new LotteryGenerator(new NumberGenerator());
        inputView = new InputView(in);
        resultView = new ResultView(out);
    }

    public void run() {

        int amount = inputView.receiveAmount();
        List<LotteryTicket> tickets = lotteryGenerator.generate(amount);
        resultView.showTickets(tickets);

        WinningNumbers winningNumbers = new WinningNumbers(
                inputView.receiveWinningNumbers(),
                inputView.receiveBonusNumber());
        Map<WinningRanking, Long> winningTickets = winningNumbers.getWinningTickets(tickets);
        resultView.showStatistics(winningTickets);
        resultView.showRevenueRate(amount, winningTickets);
    }
}
