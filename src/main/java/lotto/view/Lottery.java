package lotto.view;

import lotto.domain.Lotteries;

public class Lottery {

    public static void printLotteries(String purchaseAmount) {

        Lotteries lotteries = new Lotteries(purchaseAmount);

        lotteries.generationAllLotto();

        StringBuilder printFormatLotteries = lotteries.toStringAllLotteries();

        System.out.println(printFormatLotteries);
    }

}
