package lottery.view;

import java.util.Scanner;
import lottery.domain.ClientLotteryPurchasePrice;

public class PriceInputView {

    private static final String PRICE_INPUT_MSG = "구매금액을 입력해 주세요";

    private static final String LOTTERIES_NUMBER_GUID = "개를 구매했습니다.";

    public static ClientLotteryPurchasePrice buyLotteries() {
        printSource(PRICE_INPUT_MSG);
        ClientLotteryPurchasePrice clientLotteryPurchasePrice
                = new ClientLotteryPurchasePrice(new Scanner(System.in).nextInt());
        printSource(clientLotteryPurchasePrice.getLotteries()+LOTTERIES_NUMBER_GUID);
        return clientLotteryPurchasePrice;
    }

    private static void printSource(String source) {
        System.out.println(source);
    }
}
