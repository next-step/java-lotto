package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoRanks {
    private final Map<LottoRank, Integer> ranks;

    public LottoRanks(Lottos lottos, Lotto winLotto, LottoNumber bonus) {
        this.ranks = lottos.findRanks(winLotto, bonus);
    }

    public Money findPrizeMoney() {
        Money money = new Money(0);
        for (LottoRank lottoRank : ranks.keySet()) {
            money = money.plus(lottoRank.sumPrize(ranks.get(lottoRank)));
        }
        return money;
    }

    public Map<LottoRank, Integer> find() {
        Map<LottoRank, Integer> rankList = new EnumMap<>(LottoRank.class);

        for (LottoRank lottoRank : LottoRank.values()) {
            addRankResult(rankList, lottoRank);
        }

        return Collections.unmodifiableMap(rankList);
    }

    private void addRankResult(Map<LottoRank, Integer> rankList, LottoRank lottoRank) {
        if (lottoRank.count() > 0) {
            rankList.put(lottoRank, this.ranks.getOrDefault(lottoRank, 0));
        }
    }


}
