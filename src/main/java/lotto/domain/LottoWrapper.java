package lotto.domain;

import lotto.enumerate.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWrapper {
    private final List<Lotto> lottos;

    LottoWrapper(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        if (lottos == null) {
            return 0;
        }
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<Rank> getResultRanks(LottoNumbersWrapper lastWeeksCollectNumberList, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(getResultRank(lotto, lastWeeksCollectNumberList, bonusNumber));
        }
        return ranks;
    }

    private Rank getResultRank(Lotto lotto, LottoNumbersWrapper lastWeeksCollectNumberList, int bonusNumber) {
        int matchCount = lotto.getMatchCount(lastWeeksCollectNumberList);
        boolean matchToBonusNumber = lotto.isMatchToBonusNumber(bonusNumber);
        return Rank.valueOf(matchCount, matchToBonusNumber);
    }
}
