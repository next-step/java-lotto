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

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static void main(String[] args) {
        LottoController controller = new LottoController(new ConsoleInputView(), new OutputView());
        controller.run();
    }

    public void run() {
        PaymentReceipt receipt = inputView.purchase();
        Integer count = receipt.getUserCountBy(new LotteryTicket());
        outputView.userPurchased(count);

        LotteryTickets myTickets = LotteryTickets.makeAutoTickets(count);
        outputView.printAutoLottery(myTickets);

        LotteryTicket winningTicket = getWinningTicket();
        getResult(myTickets, winningTicket, receipt);

        inputView.closeScanner();
    }

    private void getResult(LotteryTickets myTickets, LotteryTicket winningTicket, PaymentReceipt receipt) {
        FinalResult result = myTickets.getResult(winningTicket);
        outputView.printResult(result, receipt);
    }

    private LotteryTicket getWinningTicket() {
        return inputView.lastWeekNumber();
    }

}
