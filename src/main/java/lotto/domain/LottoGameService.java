package lotto.domain;

import java.security.InvalidParameterException;
import java.util.List;

public class LottoGameService {
    private static final int PRICE = 1000;

    public static int calculateTerms(int money) {
        if (money < PRICE) {
            throw new InvalidParameterException("1000 원 이하면 게임이 불가능합니다.");
        }
        return money / PRICE;
    }

    public static double calculateYield(int investment, int winnings) {
        return (double) winnings / investment;
    }


    public static Lottos getLottos(int inputMoney) {
        return new Lottos(calculateTerms(inputMoney));
    }

    public static List<LottoResult> getResults(Lottos lottos, Lotto winnings) {
        return lottos.getResults(winnings);
    }
}
