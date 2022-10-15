package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoRankRecordBox {

    private final List<LottoRankRecord> lottoRankRecords;

    public LottoRankRecordBox(List<LottoRankRecord> lottoRankRecords) {
        this.lottoRankRecords = lottoRankRecords;
    }

    public double retrieveWinPrizeSum() {
        double sum = 0;
        for (LottoRankRecord lottoRankRecord : lottoRankRecords) {
            LottoRank rank = lottoRankRecord.getRank();
            int number = lottoRankRecord.getNumber();
            int winPrize = rank.getWinPrize() * number;
            sum += winPrize;
        }
        return sum;
    }

    public List<LottoRankRecord> getLottoRankRecords() {
        return Collections.unmodifiableList(lottoRankRecords);
    }
}
