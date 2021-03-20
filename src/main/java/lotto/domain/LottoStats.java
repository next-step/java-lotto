package lotto.domain;

import java.util.List;

public class LottoStats {
    private static final int ONE_GAME_PRICE = 1000;
    private int numberOfLottoGameResults;
    private RankingTable rankingTable;

    public LottoStats(List<LottoMatchNumbers> lottoNumberMatches) {
        rankingTable = new RankingTable(lottoNumberMatches);
        numberOfLottoGameResults = lottoNumberMatches.size();
    }

    public RankingRecord record(Rank rank) {
        return rankingTable.record(rank);
    }

    public double yield() {
        return rankingTable.amounts() / cost();
    }

    private double cost() {
        return (numberOfLottoGameResults * ONE_GAME_PRICE);
    }
}
