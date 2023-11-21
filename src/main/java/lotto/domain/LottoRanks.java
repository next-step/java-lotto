package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoRanks {
    private Map<LottoRank, Integer> lottoRanks;

    public LottoRanks(Lottos lottos, Lotto winLotto, LottoNumber bonus) {
        this.lottoRanks = lottos.callRanks(winLotto, bonus);
    }

    public Map<LottoRank, Integer> findLottoResult() {
        Map<LottoRank, Integer> map = new EnumMap<>(LottoRank.class);

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.count() > 0) {
                map.put(lottoRank, lottoRanks.getOrDefault(lottoRank, 0));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public Money findPrizeMoney() {
        Money money = new Money(0);
        for (LottoRank lottoRank : lottoRanks.keySet()) {
            money = money.plus(lottoRank.sumPrize(lottoRanks.get(lottoRank)));
        }
        return money;
    }
}
