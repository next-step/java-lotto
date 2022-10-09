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

    public List<Rank> getResultRanks(LottoNumbersWrapper lastWeeksCollectNumbers, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(getResultRank(lotto, lastWeeksCollectNumbers, bonusNumber));
        }
        return ranks;
    }

    private Rank getResultRank(Lotto lotto, LottoNumbersWrapper lastWeeksCollectNumbers, int bonusNumber) {
        int matchCount = lotto.getMatchCount(lastWeeksCollectNumbers);
        boolean matchToBonusNumber = lotto.isMatchToBonusNumber(bonusNumber);
        return Rank.valueOf(matchCount, matchToBonusNumber);
    }
}
