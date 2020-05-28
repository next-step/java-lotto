package lotto.domain;

import java.util.List;

public class LottoStatisticUtil {

    public static int getPrizeCount(Prize prize, Lotto winLotto, List<Lotto> lottoList) {
        int count = 0;
        for (Lotto lotto : lottoList) {
            count += prize == Prize.award(winLotto, lotto) ? 1 : 0;
        }
        return count;
    }
}
