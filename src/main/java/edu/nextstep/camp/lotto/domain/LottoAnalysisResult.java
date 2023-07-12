package edu.nextstep.camp.lotto.domain;

import java.util.List;

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
        return lottoRankList.size() * 1000;
    }

    private int lottoRankEqual(LottoRank lottoRank, LottoRank other) {
        if (lottoRank.equals(other)) {
            return 1;
        }

        return 0;
    }

}
