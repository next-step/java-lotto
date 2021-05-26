package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoRecord {
    private final Map<LottoRank, Integer> lottoRecord;

    public LottoRecord() {
        this.lottoRecord = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoRecord.put(lottoRank, 0);
        }
    }

    public void recordRank(LottoRank lottoRank) {
        lottoRecord.put(lottoRank, lottoRecord.get(lottoRank) + 1);
    }

    public boolean isRecord(LottoRank lottoRank, int expected) {
        return lottoRecord.get(lottoRank) == expected;
    }

}
