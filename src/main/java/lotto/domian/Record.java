package lotto.domian;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Record {

    private final Map<Rank, Integer> rankMap;

    public Record(Map<Rank, Integer> rankMap) {
        this.rankMap = rankMap;
    }

    public Map<Rank, Integer> getRecord() {
        return new EnumMap<>(rankMap);
    }

    public static Record extractRecord(LottoBundle lottoBundle, WinNumber winNumber) {
        Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
        List<Lotto> lottoList = lottoBundle.unfoldLottoBundle();
        for (Lotto lotto : lottoList) {
            Rank rank = winNumber.match(lotto);
            putRankMap(rank, rankMap);
        }

        return new Record(rankMap);
    }

    private static void putRankMap(Rank rank, Map<Rank, Integer> rankMap) {
        if (rank.getMatchingCount() >= 3) {
            rankMap.merge(rank, 1, Integer::sum);
        }
    }

}