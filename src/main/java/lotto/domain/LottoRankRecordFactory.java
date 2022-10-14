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

    public static List<LottoRankRecord> createLottoRankRecords(List<CorrectInfo> correctInfos) {
        List<LottoRankRecord> lottoRankRecords = new ArrayList<>();
        Map<LottoRank, Integer> rankRecord = recordWinRank(correctInfos);
        for (LottoRank lottoRank : rankRecord.keySet()) {
            int number = rankRecord.get(lottoRank);
            lottoRankRecords.add(new LottoRankRecord(lottoRank, number));
        }
        return Collections.unmodifiableList(lottoRankRecords);
    }

    private static Map<LottoRank, Integer> recordWinRank(List<CorrectInfo> correctInfos) {
        Map<LottoRank, Integer> rankRecord = initilizeRankRecord();
        for (CorrectInfo correctInfo : correctInfos) {
            insertRankValue(rankRecord, LottoRank.findRank(correctInfo.getCorrectCount(), correctInfo.isBonus()));
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
