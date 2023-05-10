package lotto.domian;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Record {

    private final Map<Rank, Integer> rankMap;

    public Record(Map<Rank, Integer> rankMap) {
        this.rankMap = rankMap;
    }

    public Record(EnumMap<Rank, Integer> rankMap) {
        this.rankMap = rankMap;
    }

    public Map<Rank, Integer> getRecord() {
        return new EnumMap<>(rankMap);
    }

    public static Record extractRecord(LottoBundle lottoBundle, WinNumber winNumber) {
        EnumMap<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
        List<Lotto> lottoList = lottoBundle.unfoldLottoBundle();
        for (Lotto lotto : lottoList) {
            int matchingCount = winNumber.distinguish(lotto);
            putRankMap(matchingCount, rankMap);
        }
        return new Record(rankMap);
    }

    public static ProfitRate calculateProfit(int purchaseMoney, Record record) {
        double allPrize = 0;
        for (Rank rank : record.getRecord().keySet()) {
            int prize = rank.getPrize();
            int matchingCount = record.getRecord().get(rank);
            allPrize += prize * matchingCount;
        }

        return new ProfitRate(allPrize / purchaseMoney);
    }

    private static void putRankMap(int matchingCount, EnumMap<Rank, Integer> rankMap) {
        if (matchingCount >= 3) {
            Rank rank = Rank.find(matchingCount);
            rankMap.merge(rank, rankMap.get(rank), (v1, v2) -> (v1 + v2));
        }
    }

}