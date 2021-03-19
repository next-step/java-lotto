package lotto;

import java.util.List;

public class LottoStats {
    private final int oneGamePrice;
    private int numberOfLottoGameResults;
    private RankingTable rankingTable;

    public LottoStats(List<LottoGameResult> lottoGameResults) {
        oneGamePrice = 1000;
        rankingTable = new RankingTable(lottoGameResults);
        numberOfLottoGameResults = lottoGameResults.size();
    }

    public RankingRecord record(Rank rank) {
        return rankingTable.record(rank);
    }


    public double yield() {
        return rankingTable.amounts() / (numberOfLottoGameResults * oneGamePrice);
    }
}
