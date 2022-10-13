package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<LottoRankRecord> lottoRankRecords;

    public LottoResult(List<LottoRankRecord> lottoRankRecords) {
        this.lottoRankRecords = lottoRankRecords;
    }

    public List<LottoRankRecord> getLottoRankRecords() {
        return lottoRankRecords.stream()
                .filter(lottoRankRecord -> lottoRankRecord.isNotRank(LottoRank.NONE))
                .collect(Collectors.toList());
    }

    public double retrieveProfitRatio(int originAmount) {
        double sum = 0;
        for (LottoRankRecord lottoRankRecord : lottoRankRecords) {
            LottoRank rank = lottoRankRecord.getRank();
            int number = lottoRankRecord.getNumber();
            int winPrize = rank.getWinPrize() * number;
            sum += winPrize;
        }
        return getTwoDecimalPointResult(sum, originAmount);
    }

    static double getTwoDecimalPointResult(double sum, int originAmount) {
        return Math.floor(sum / originAmount * 100) / 100;
    }
}
