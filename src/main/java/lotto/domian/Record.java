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
            int matchingCount = winNumber.distinguish(lotto);
            boolean haveBonus = winNumber.haveBonus(lotto);
            putRankMap(matchingCount, rankMap, haveBonus);
        }

        return new Record(rankMap);
    }

    private static void putRankMap(int matchingCount, Map<Rank, Integer> rankMap, boolean haveBonus) {
        if (matchingCount >= 3) {
            Rank rank = Rank.find(new MatchCount(matchingCount), haveBonus);
            rankMap.merge(rank, 1, Integer::sum);
        }
    }

}