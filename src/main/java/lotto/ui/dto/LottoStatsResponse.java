package lotto.ui.dto;

import lotto.domain.LottoStat;
import lotto.domain.Money;
import lotto.domain.ReceiveMoney;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoStatsResponse {
    private final List<LottoStatResponse> lottoStats = new ArrayList<>();
    private final float profitRate;

    public LottoStatsResponse(List<LottoStatResponse> lottoStats, float profitRate) {
        this.lottoStats.addAll(lottoStats);
        this.profitRate = profitRate;
    }

    public static LottoStatsResponse from(LottoStat lottoStat, Money money) {
        LottoStatResponse lottoMatch3 = new LottoStatResponse(3, lottoStat.getMatchCountResult(3), ReceiveMoney.MATCH_3_RECEIVE_MONEY.getMoney());
        LottoStatResponse lottoMatch4 = new LottoStatResponse(4, lottoStat.getMatchCountResult(4), ReceiveMoney.MATCH_4_RECEIVE_MONEY.getMoney());
        LottoStatResponse lottoMatch5 = new LottoStatResponse(5, lottoStat.getMatchCountResult(5), ReceiveMoney.MATCH_5_RECEIVE_MONEY.getMoney());
        LottoStatResponse lottoMatch6 = new LottoStatResponse(6, lottoStat.getMatchCountResult(6), ReceiveMoney.MATCH_6_RECEIVE_MONEY.getMoney());

        return new LottoStatsResponse(Arrays.asList(lottoMatch3, lottoMatch4, lottoMatch5, lottoMatch6), lottoStat.getProfitRate(money));
    }

    public List<LottoStatResponse> getLottoStats() {
        return lottoStats;
    }

    public float getProfitRate() {
        return profitRate;
    }
}
