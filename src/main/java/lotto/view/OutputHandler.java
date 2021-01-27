package lotto.view;

import lotto.Constant;

public class OutputHandler {

    public void printLottoPurchaseCount(String count) {
        System.out.println(createLottoPurchaseCount(count));
    }
    private StringBuilder createLottoPurchaseCount(String count) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(count).append(Constant.REMIND_LOTTO_COUNT);
    }
}
