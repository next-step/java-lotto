package edu.nextstep.camp.lotto.domain;

import java.util.List;

import static edu.nextstep.camp.lotto.domain.LottoGame.LOTTO_BUY_AMOUNT_UNIT;

public class LottoAnalysisResult {

    private final List<LottoRank> lottoRankList;

    public LottoAnalysisResult(List<LottoRank> lottoRankList) {
        this.lottoRankList = lottoRankList;
    }

    public int countByLottoRank(LottoRank lottoRank) {
        int count = 0;

        for (LottoRank other : lottoRankList) {
            count += lottoRankEqual(lottoRank, other);
        }

        return count;
    }


    public String earningRate() {
        double sum = 0;

        for (LottoRank lottoRank : lottoRankList) {
            sum += lottoRank.getWinnings();
        }

        return String.format("%.2f", sum / amountPaid());
    }

    private long amountPaid(){
        return lottoRankList.size() * LOTTO_BUY_AMOUNT_UNIT;
    }

    private int lottoRankEqual(LottoRank lottoRank, LottoRank other) {
        if (lottoRank.equals(other)) {
            return 1;
        }

        return 0;
    }

}
