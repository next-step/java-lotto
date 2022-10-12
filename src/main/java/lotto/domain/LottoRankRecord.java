package lotto.domain;

public class LottoRankRecord {

    private LottoRank lottoRank;
    private int number;

    public LottoRankRecord(LottoRank lottoRank, int number) {
        this.lottoRank = lottoRank;
        this.number = number;
    }

    public int calculateSum() {
        return lottoRank.getWinPrize() * number;
    }

    public LottoRank getRank() {
        return lottoRank;
    }

    public int getNumber() {
        return number;
    }

    public boolean isNotRank(LottoRank rank) {
        return !rank.equals(lottoRank);
    }
}
