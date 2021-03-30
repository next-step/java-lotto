package lotto.domain;

import java.util.List;

public class LottoRanks {

    private final List<LottoRank> lottoRankList;

    public LottoRanks(List<LottoRank> lottoRankList) {
        validate(lottoRankList);
        this.lottoRankList = lottoRankList;
    }

    private void validate(List<LottoRank> lottoRankList) {
        if (lottoRankList == null || lottoRankList.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public int matchLottoCount(LottoRank lottoRank) {
        return (int) lottoRankList.stream().filter(lottoRankResult -> lottoRankResult == lottoRank).count();
    }

    public double totalReturnRate() {
        double totalWinAmount = totalWinAmount();
        double purchaseAmount = lottoRankList.size() * LottoConstant.LOTTO_PRICE;
        return Math.floor(totalWinAmount / purchaseAmount * 100) / 100;
    }

    private long totalWinAmount() {
        long totalWinAmount = 0L;
        for (LottoRank lottoRank : lottoRankList) {
            totalWinAmount += lottoRank.getWinAmount();
        }
        return totalWinAmount;
    }
}
