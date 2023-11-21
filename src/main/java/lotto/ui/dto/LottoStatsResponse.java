package lotto.ui.dto;

import lotto.domain.LottoResult;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoPrize.FIFTH;
import static lotto.domain.LottoPrize.FIRST;
import static lotto.domain.LottoPrize.FOURTH;
import static lotto.domain.LottoPrize.THIRD;

public class LottoStatsResponse {
    private final List<LottoStatResponse> lottoStats = new ArrayList<>();
    private final float profitRate;

    public LottoStatsResponse(List<LottoStatResponse> lottoStats, float profitRate) {
        this.lottoStats.addAll(lottoStats);
        this.profitRate = profitRate;
    }

    public static LottoStatsResponse from(LottoResult lottoResult, Money money) {
        LottoStatResponse lottoMatch3 = new LottoStatResponse(FIFTH.getMatchCount(), lottoResult.getPrizeCount(FIFTH), FIFTH.getMoney());
        LottoStatResponse lottoMatch4 = new LottoStatResponse(FOURTH.getMatchCount(), lottoResult.getPrizeCount(FOURTH), FOURTH.getMoney());
        LottoStatResponse lottoMatch5 = new LottoStatResponse(THIRD.getMatchCount(), lottoResult.getPrizeCount(THIRD), THIRD.getMoney());
        LottoStatResponse lottoMatch6 = new LottoStatResponse(FIRST.getMatchCount(), lottoResult.getPrizeCount(FIRST), FIRST.getMoney());

        return new LottoStatsResponse(Arrays.asList(lottoMatch3, lottoMatch4, lottoMatch5, lottoMatch6), lottoResult.getProfitRate(money));
    }

    public List<LottoStatResponse> getLottoStats() {
        return lottoStats;
    }

    public float getProfitRate() {
        return profitRate;
    }
}
