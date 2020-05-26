package lottery;

import lottery.domain.LotteryMachine;
import lottery.domain.PurchasePrice;
import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = new PurchasePrice(InputView.getPurchasePrice());
        LotteryMachine lotteryMachine = new LotteryMachine(purchasePrice);

        ResultView.printLottoTicketCounts(lotteryMachine.getLotteryTicketCounts());
    }
}
