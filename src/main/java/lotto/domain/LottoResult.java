package lotto.domain;

import lotto.LottoRank;

import java.util.*;

public class LottoResult {

    List<LottoRank> winningRankList = new ArrayList<>();

    public LottoResult() {
    }

    public LottoResult(List<LottoRank> lottoRanks) {
        winningRankList = lottoRanks;
    }


    public void updateWinningCount(LottoRank lottoRank) {
        winningRankList.add(lottoRank);
    }

    public long countRank(LottoRank lottoRank) {
        return winningRankList.stream()
                .filter(rank -> rank.equals(lottoRank)).count();
    }

    public int winningAmount() {
        return winningRankList.stream().mapToInt(LottoRank::lottoWinningAmount).sum();
    }

    public double calculateMarginPercent(int purchaseAmount) {
        MarginAmount marginAmount = new MarginAmount(winningAmount());
        return marginAmount.calculateMarginPercent(purchaseAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(winningRankList, that.winningRankList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winningRankList);
    }

}
