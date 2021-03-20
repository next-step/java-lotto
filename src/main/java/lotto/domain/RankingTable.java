package lotto.domain;


import java.util.*;

public class RankingTable {
    private Map<Integer, RankingRecord> table;

    public RankingTable(LottoMatchNumbers lottoMatchNumbers) {
        this(Arrays.asList(lottoMatchNumbers));
    }

    public RankingTable(List<LottoMatchNumbers> lottoNumberMatches) {
        table = new HashMap<>();
        for (Rank rank : Rank.values()) {
            table.put(rank.matchCount(), new RankingRecord(rank));
        }

        for (LottoMatchNumbers numberMatches : lottoNumberMatches) {
            int matchCount = numberMatches.matchCount();
            if (Rank.isValid(matchCount))
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
