package lotto.ui.dto;

import lotto.domain.LottoResult;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoPrize.FirstPrizeMoney;
import static lotto.domain.LottoPrize.ForthPrizeMoney;
import static lotto.domain.LottoPrize.SecondPrizeMoney;
import static lotto.domain.LottoPrize.ThirdPrizeMoney;

public class LottoStatsResponse {
    private final List<LottoStatResponse> lottoStats = new ArrayList<>();
    private final float profitRate;

    public LottoStatsResponse(List<LottoStatResponse> lottoStats, float profitRate) {
        this.lottoStats.addAll(lottoStats);
        this.profitRate = profitRate;
    }

    public static LottoStatsResponse from(LottoResult lottoResult, Money money) {
        LottoStatResponse lottoMatch3 = new LottoStatResponse(ForthPrizeMoney.getMatchCount(), lottoResult.getPrizeCount(ForthPrizeMoney), ForthPrizeMoney.getMoney());
        LottoStatResponse lottoMatch4 = new LottoStatResponse(ThirdPrizeMoney.getMatchCount(), lottoResult.getPrizeCount(ThirdPrizeMoney), ThirdPrizeMoney.getMoney());
        LottoStatResponse lottoMatch5 = new LottoStatResponse(SecondPrizeMoney.getMatchCount(), lottoResult.getPrizeCount(SecondPrizeMoney), SecondPrizeMoney.getMoney());
        LottoStatResponse lottoMatch6 = new LottoStatResponse(FirstPrizeMoney.getMatchCount(), lottoResult.getPrizeCount(FirstPrizeMoney), FirstPrizeMoney.getMoney());

        return new LottoStatsResponse(Arrays.asList(lottoMatch3, lottoMatch4, lottoMatch5, lottoMatch6), lottoResult.getProfitRate(money));
    }

    public List<LottoStatResponse> getLottoStats() {
        return lottoStats;
    }

    public float getProfitRate() {
        return profitRate;
    }
}
