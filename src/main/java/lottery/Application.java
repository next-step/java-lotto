package lottery;


import lottery.board.LotteryGameBoard;
import lottery.domain.LotteryRank;
import lottery.view.InputView;
import lottery.view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        LotteryGameBoard board = new LotteryGameBoard();
        final int price = InputView.inputPrice();
        final int count = board.buyLotteryTicket(price);

        InputView.viewTicketCount(count);
        ResultView.viewTickets(board.getTickets());

        final List<LotteryRank> lotteryRanks = board.checkWinningNumbers(InputView.inputWinningNumbers());
        ResultView.viewStatistics(price, lotteryRanks);
    }
}
