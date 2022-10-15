package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankRecordBoxFactory {

    private LottoRankRecordBoxFactory() {
    }

    public static LottoRankRecordBox createLottoRankRecordBox(List<WinningResult> correctInfos) {
        List<LottoRankRecord> lottoRankRecords = new ArrayList<>();

        Map<LottoRank, Integer> rankRecord = recordWinRank(correctInfos);
        for (LottoRank lottoRank : rankRecord.keySet()) {
            int number = rankRecord.get(lottoRank);
            lottoRankRecords.add(new LottoRankRecord(lottoRank, number));
        }

        return new LottoRankRecordBox(lottoRankRecords);
    }

    private static Map<LottoRank, Integer> recordWinRank(List<WinningResult> correctInfos) {
        Map<LottoRank, Integer> rankRecord = initilizeRankRecord();
        for (WinningResult winningResult : correctInfos) {
            insertRankValue(rankRecord, LottoRank.findRank(winningResult));
        }
        return rankRecord;
    }

    private static Map<LottoRank, Integer> initilizeRankRecord() {
        Map<LottoRank, Integer> rankRecrod = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            rankRecrod.put(lottoRank, 0);
        }
        return rankRecrod;
    }

    private static void insertRankValue(Map<LottoRank, Integer> rankRecord, LottoRank rank) {
        rankRecord.put(rank, rankRecord.get(rank) + 1);
    }


}
