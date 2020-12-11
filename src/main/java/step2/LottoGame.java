package step2;

import java.util.List;

public class LottoGame {

    private static List<Lottery> lotteryList;

    public int buy(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(Constants.MONEY_IS_LESS_THAN_1000);
        }
        return 0;
    }
}
