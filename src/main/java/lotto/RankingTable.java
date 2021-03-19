package lotto;


import java.util.*;

public class RankingTable {
    private Map<Integer, RankingRecord> table;

    public RankingTable(LottoGameResult lottoGameResult) {
        this(Arrays.asList(lottoGameResult));
    }

    public RankingTable(List<LottoGameResult> lottoGameResults) {
        table = new HashMap<>();
        for (Rank rank : Rank.values()) {
            table.put(rank.matchCount(), new RankingRecord(rank));
        }

        for (LottoGameResult lottoGameResult : lottoGameResults) {
            int matchCount = lottoGameResult.matchCount();
            table.put(matchCount, table.get(matchCount).increaseWinner());
        }
    }

    public RankingRecord record(int matchCount) {
        return table.get(matchCount);
    }

    public RankingRecord record(Rank rank) {
        return record(rank.matchCount());
    }

    public int amounts() {
        int amounts = 0;
        for (RankingRecord r : table.values()) {
            amounts += r.amounts();
        }

        return amounts;
    }
}
