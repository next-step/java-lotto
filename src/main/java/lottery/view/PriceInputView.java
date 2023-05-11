package lottery.view;

import static lottery.view.BlankPrintView.printBlank;

import java.util.Scanner;
import lottery.domain.LotteryPrice;
import lottery.domain.ManualQuantity;
import lottery.domain.PurchasedLottery;

public class PriceInputView {

    private static final String PRICE_INPUT_MSG = "구매금액을 입력해 주세요";

    private static final String MANUAL_QUANTITY_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static PurchasedLottery buyLotteries() {
        printSource(PRICE_INPUT_MSG);

        final LotteryPrice lotteryPrice = new LotteryPrice(
                SCANNER.nextInt());

        printBlank();

        printSource(MANUAL_QUANTITY_MSG);

        final ManualQuantity manualQuantity = new ManualQuantity(SCANNER.nextInt());

        printBlank();

        return new PurchasedLottery(lotteryPrice, manualQuantity);
    }

    private static void printSource(String source) {
        System.out.println(source);
    }
}
