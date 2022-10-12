package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankRecordFactory {

    private LottoRankRecordFactory() {
    }

    public static List<LottoRankRecord> createLottoRankRecords(List<Integer> correctNums) {
        List<LottoRankRecord> lottoRankRecords = new ArrayList<>();
        Map<LottoRank, Integer> rankRecord = recordWinRank(correctNums);
        for (LottoRank lottoRank : rankRecord.keySet()) {
            int number = rankRecord.get(lottoRank);
            lottoRankRecords.add(new LottoRankRecord(lottoRank, number));
        }
        return Collections.unmodifiableList(lottoRankRecords);
    }

    private static Map<LottoRank, Integer> recordWinRank(List<Integer> correctNums) {
        Map<LottoRank, Integer> rankRecord = initilizeRankRecord();
        for (Integer correctNum : correctNums) {
            insertRankValue(rankRecord, LottoRank.findRank(correctNum));
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
        if (!LottoRank.NONE.equals(rank)) {
            rankRecord.put(rank, rankRecord.get(rank) + 1);
        }
    }


}
