package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by yusik on 2019/11/05.
 */
public class LotteryMachine {

    private static final int TICKET_PRICE = 1_000;

    private final LotteryGenerator lotteryGenerator;
    private final InputView inputView;
    private final ResultView resultView;

    public LotteryMachine(InputStream in, PrintStream out) {
        lotteryGenerator = new LotteryGenerator();
        inputView = new InputView(in);
        resultView = new ResultView(out);
    }

    public void run() {

        int ticketCount = inputView.receiveAmount() / TICKET_PRICE;
        List<LotteryTicket> tickets = lotteryGenerator.generate(ticketCount);
        resultView.showTickets(tickets);

        List<Integer> winningNumbers = inputView.receiveWinningNumbers();
        resultView.showStatistics();
    }
}
