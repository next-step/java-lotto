package lotto.ui.dto;

import lotto.domain.LottoResult;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoPrize.FIFTH;
import static lotto.domain.LottoPrize.FIRST;
import static lotto.domain.LottoPrize.FOURTH;
import static lotto.domain.LottoPrize.SECOND;
import static lotto.domain.LottoPrize.THIRD;

public class LottoStatsResponse {
    private final List<LottoStatResponse> lottoStats = new ArrayList<>();
    private final float profitRate;

    public LottoStatsResponse(List<LottoStatResponse> lottoStats, float profitRate) {
        this.lottoStats.addAll(lottoStats);
        this.profitRate = profitRate;
    }

    public static LottoStatsResponse from(LottoResult lottoResult, Money money) {
        LottoStatResponse firstResponse = new LottoStatResponse(FIRST.getMatchCount(), lottoResult.getPrizeCount(FIRST), FIRST.getMoney());
        LottoStatResponse secondResponse = new LottoStatResponse(SECOND.getMatchCount(), lottoResult.getPrizeCount(SECOND), SECOND.getMoney());
        LottoStatResponse thirdResponse = new LottoStatResponse(THIRD.getMatchCount(), lottoResult.getPrizeCount(THIRD), THIRD.getMoney());
        LottoStatResponse fourthResponse = new LottoStatResponse(FOURTH.getMatchCount(), lottoResult.getPrizeCount(FOURTH), FOURTH.getMoney());
        LottoStatResponse fifthResponse = new LottoStatResponse(FIFTH.getMatchCount(), lottoResult.getPrizeCount(FIFTH), FIFTH.getMoney());

        return new LottoStatsResponse(Arrays.asList(fifthResponse, fourthResponse, thirdResponse, secondResponse, firstResponse), lottoResult.getProfitRate(money));
    }

    public List<LottoStatResponse> getLottoStats() {
        return lottoStats;
    }

    public float getProfitRate() {
        return profitRate;
    }
}
