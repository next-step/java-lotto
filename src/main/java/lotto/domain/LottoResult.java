package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult(LottoGroup lottoGroup, Lotto winLotto) {
        this(calculate(lottoGroup, winLotto));
    }
    public  LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    private static Map<LottoRank, Integer> calculate(LottoGroup lottoGroup, Lotto winLotto) {
        Map<LottoRank, Integer> reusltMap = initResult();

        for (Lotto lotto : lottoGroup.getLottoNumbers()) {
            int cnt = lotto.matchedCount(winLotto);
            LottoRank lottoRank = LottoRank.getLottoRank(cnt);

            if (lottoRank != null) {
                reusltMap.put(lottoRank, reusltMap.get(lottoRank) + 1);
            }
        }

        return reusltMap;
    }
    private static Map<LottoRank, Integer> initResult() {
        Map<LottoRank, Integer> map = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            map.put(lottoRank, 0);
        }

        return map;
    }

    public int calTotal() {
        int sum = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            sum += result.get(lottoRank) * lottoRank.getPrizeMoney();
        }
        return sum;
    }

    public int getCntByLottoRank(LottoRank lottoRank) {
        return result.get(lottoRank);
    }
}
