package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoRecord {
    private final Map<LottoRank, Integer> lottoRecord;

    public LottoRecord() {
        this.lottoRecord = new HashMap<>();
    }

    public void recordRank(LottoRank lottoRank) {
        if (!lottoRecord.containsKey(lottoRank)) {
            lottoRecord.put(lottoRank, 1);
            return;
        }
        lottoRecord.put(lottoRank, lottoRecord.get(lottoRank) + 1);
    }

    public boolean isRecord(LottoRank lottoRank, int expected){
        return lottoRecord.get(lottoRank) == expected;
    }

}
