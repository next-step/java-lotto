package lotto.domain;

import java.util.Objects;

public class LottoRankRecord {

    private final LottoRank lottoRank;
    private final int number;

    public LottoRankRecord(LottoRank lottoRank, int number) {
        this.lottoRank = lottoRank;
        this.number = number;
    }

    public long calculateSum() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoRankRecord that = (LottoRankRecord) o;
        return number == that.number && lottoRank == that.lottoRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRank, number);
    }
}
