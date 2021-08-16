package lotto.step3.view;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lottery;
import lotto.step3.domain.Money;

public class ResultView {

    public static void printLottoInfo(int money, Lotteries lotteries) {
        System.out.println(money / Money.LOTTO_PRICE + "개를 구매했습니다.");
        for (Lottery lottery : lotteries.getLotteries()) {
            System.out.println(lottery);
        }

    }
}
