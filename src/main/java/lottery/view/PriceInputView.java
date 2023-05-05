package lottery.view;

import java.util.Scanner;
import lottery.domain.LotteryPurchasePrice;

public class PriceInputView {

    private static final String PRICE_INPUT_MSG = "구매금액을 입력해 주세요";

    private static final String LOTTERIES_NUMBER_GUID = "개를 구매했습니다.";

    public static LotteryPurchasePrice buyLotteries() {
        printSource(PRICE_INPUT_MSG);
        LotteryPurchasePrice lotteryPurchasePrice
                = new LotteryPurchasePrice(new Scanner(System.in).nextInt());
        printSource(lotteryPurchasePrice.numberOfPlays()+LOTTERIES_NUMBER_GUID);
        return lotteryPurchasePrice;
    }

    private static void printSource(String source) {
        System.out.println(source);
    }
}
