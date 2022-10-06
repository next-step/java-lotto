package lotto.domain;

import lotto.enumerate.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoWrapper {
    private final List<Lotto> lottos;

    LottoWrapper(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        if (lottos == null || lottos.isEmpty()) {
            return 0;
        }
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


    public List<Rank> getResultRanks(List<Integer> lastWeeksCollectNumberList, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        this.lottos.forEach((lotto) -> {
            int matchCount = lotto.getMatchCount(lastWeeksCollectNumberList);
            boolean matchToBonusNumber = lotto.isMatchToBonusNumber(bonusNumber);
            ranks.add(Rank.valueOf(matchCount, matchToBonusNumber));
        });
        return ranks;
    }
}
