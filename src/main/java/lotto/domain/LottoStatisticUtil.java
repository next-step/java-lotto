package lotto.domain;

import java.util.Arrays;

public class LottoStatisticUtil {

    public static int getPrizeCount(Prize prize, Lotto winLotto, int bonusNumber, Lottos lottos) {
        int count = 0;
        for (Lotto lotto : lottos.getLottoList()) {
            count += prize == Prize.award(winLotto, lotto.isBonusMatched(bonusNumber), lotto) ? 1 : 0;
        }
        return count;
    }

    public static double getYield(Price totalPrice, Lotto winLotto, int bonusMatched, Lottos lottos) {
        double prizeMoney = Arrays.stream(Prize.generateInRank()).map(prize ->
                getPrizeCount(prize, winLotto, bonusMatched, lottos) * prize.getMoney()
        ).reduce(Long::sum).orElse(0L);

        return prizeMoney / totalPrice.getPrice();
    }
}
