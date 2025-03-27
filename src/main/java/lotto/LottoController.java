package lotto;

import lotto.domain.PaymentReceipt;
import lotto.domain.product.FinalResult;
import lotto.domain.product.LotteryTicket;
import lotto.domain.product.LotteryTickets;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final LotteryTickets tickets;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        tickets = new LotteryTickets();
    }

    public static void main(String[] args) {
        LottoController controller = new LottoController(new ConsoleInputView(), new OutputView());
        controller.run();
    }

    public void run() {
        PaymentReceipt receipt = inputView.purchase();
        Integer count = receipt.getUserCountBy(new LotteryTicket());
        outputView.userPurchased(count);

        makeAutoLotteryNumbers(count);

        LotteryTicket winningTicket = getWinningTicket();
        getResult(winningTicket, receipt);

        inputView.closeScanner();
    }

    private void getResult(LotteryTicket winningTicket, PaymentReceipt paid) {
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
