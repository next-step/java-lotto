package lotto;

import java.util.ArrayList;
import java.util.List;

public abstract class LottoMachine {

    public static List<Rank> findUserLottoRanks(List<Lotto> userLottoList, Lotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto userLotto : userLottoList) {
            int matchCount = userLotto.findMatchedLottoNumberCount(winningLotto);
            ranks.add(Rank.findRank(matchCount, false));
        }

        return ranks;
    }
}
