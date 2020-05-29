package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoStatisticUtil {

    public static int getPrizeCount(Prize prize, Lotto winLotto, List<Lotto> lottoList) {
        int count = 0;
        for (Lotto lotto : lottoList) {
            count += prize == Prize.award(winLotto, lotto) ? 1 : 0;
        }
        return count;
    }

    public static double getYield(Price totalPrice, Lotto winLotto, List<Lotto> lottoList) {
        double prizeMoney = Arrays.stream(Prize.generateInRank()).map(prize ->
                getPrizeCount(prize, winLotto, lottoList) * prize.getMoney()
        ).reduce(Long::sum).orElse(0L);

        return prizeMoney / totalPrice.getPrice();
    }
}
