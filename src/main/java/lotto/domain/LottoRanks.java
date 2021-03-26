package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class LottoRanks {

    private final List<LottoRank> lottoRankList;

    public LottoRanks(List<LottoRank> lottoRankList) {
        validate(lottoRankList);
        this.lottoRankList = lottoRankList;
    }

    private void validate(List<LottoRank> lottoRankList) {
        if(lottoRankList==null || lottoRankList.size()==0) {
            throw new IllegalArgumentException();
        }
    }

    public int matchLottoCount(LottoRank lottoRank) {
        return (int) lottoRankList.stream().filter(lottoRankResult -> lottoRankResult==lottoRank).count();
    }

    public double totalReturnRate() {
        BigDecimal totalWinAmount = totalWinAmount();
        BigDecimal purchaseAmount = BigDecimal.valueOf((long) lottoRankList.size() * LottoConstant.LOTTO_PRICE);
        return totalWinAmount.divide(purchaseAmount, 2, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    private BigDecimal totalWinAmount() {
        BigDecimal totalWinAmount = BigDecimal.ZERO;
        for (LottoRank lottoRank : lottoRankList) {
            totalWinAmount = totalWinAmount.add(BigDecimal.valueOf(lottoRank.getWinAmount()));
        }
        return totalWinAmount;
    }
}
