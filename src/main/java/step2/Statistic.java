package step2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statistic {

    public static int sum() {
        return Arrays.stream(Rank.values())
                .mapToInt(Rank::getTotal)
                .sum();
    }


    public static BigDecimal getYield(Money money) {
        return new BigDecimal(money.getYield(sum()))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    public static void compare(List<Lotto> lottos, Lotto winLotto) {
        List<Integer> list = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int compare = lotto.compare(winLotto);
            list.add(compare);
        }
        for(Integer match : list) {
            Rank matches = Rank.matches(match);
            matches.count();
        }
    }


}
