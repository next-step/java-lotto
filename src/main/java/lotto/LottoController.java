package lotto;

import lotto.domain.PaymentHistory;
import lotto.domain.PaymentReceipt;
import lotto.domain.Quantity;
import lotto.domain.product.FinalResult;
import lotto.domain.product.LotteryTicket;
import lotto.domain.product.LotteryTickets;
import lotto.domain.product.WinningTicket;
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
        Quantity totalQuantity = receipt.getQuantityAbout(new LotteryTicket());
        Quantity manualQuantity = inputView.getManualLotteryQuantity();
        LotteryTickets manualLotteryTickets = inputView.getManualLotteryTickets(manualQuantity);

        outputView.printUserReceipt(totalQuantity, manualQuantity);
        PaymentHistory myTickets = new PaymentHistory(totalQuantity.minus(manualQuantity), manualLotteryTickets);
        outputView.printAutoLottery(myTickets);

        WinningTicket winningTicket = getWinningTicket();
        getResult(myTickets, winningTicket, receipt);

        inputView.closeScanner();
    }

    private void getResult(PaymentHistory myTickets, WinningTicket winningTicket, PaymentReceipt receipt) {
        FinalResult result = myTickets.getResult(winningTicket);
        outputView.printResult(result, receipt);
    }

    private WinningTicket getWinningTicket() {
        return inputView.getWinningTicket();
    }

}
