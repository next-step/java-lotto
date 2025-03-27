package lotto.domain;

import lotto.domain.product.FinalResult;
import lotto.domain.product.LotteryTicket;
import lotto.domain.product.LotteryTickets;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoMaker {

    private final InputView inputView;
    private final OutputView outputView;

    private final LotteryTickets tickets;

    public LottoMaker(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        tickets = new LotteryTickets();
    }

    public void run() {
        UserPaid paid = inputView.purchase();
        Integer count = paid.getUserCountBy(new LotteryTicket());
        outputView.userPurchased(count);

        makeAutoLotteryNumbers(count);

        LotteryTicket winningTicket = getWinningTicket();
        getResult(winningTicket, paid);

        inputView.closeScanner();
    }

    private void getResult(LotteryTicket winningTicket, UserPaid paid) {
        FinalResult result = tickets.getResult(winningTicket);
        outputView.printResult(result, paid);
    }

    private LotteryTicket getWinningTicket() {
        return inputView.lastWeekNumber();
    }

    private void makeAutoLotteryNumbers(Integer count) {
        for (int i = 0; i < count; i++) {
            tickets.add(new LotteryTicket());
        }

        outputView.printAutoLottery(tickets);
    }
}
