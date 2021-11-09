package lotto.service.model;

import lotto.service.domain.types.Rank;
import lotto.service.value.LottoPrice;
import lotto.utils.Preconditions;

import java.math.BigDecimal;
import java.util.Map;

public class LottoResult {
    private static final String LOSS = "손해";
    private static final String PROFIT = "이익";
    private static final Integer DEFAULT_VALUE = 0;
    private static final BigDecimal BASE_YIELD = BigDecimal.ONE;

    private final Map<Rank, Integer> lottoResult;

    public LottoResult(Map<Rank, Integer> lottoResult) {
        Preconditions.checkNotNull(lottoResult, "lottoResult는 필수값입니다.");

        this.lottoResult = lottoResult;
    }

    public static LottoResult from(Map<Rank, Integer> lottoResult) {
        return new LottoResult(lottoResult);
    }

    public Integer getCountOfMatch(Rank rank) {
        return lottoResult.getOrDefault(rank, DEFAULT_VALUE);
    }

    public BigDecimal getLottoYield(LottoPrice purchasePrice) {
        return purchasePrice.getYield(getTotalWinningMoney());
    }

    public String getProfitOrLoss(LottoPrice purchasePrice) {
        return getLottoYield(purchasePrice).compareTo(BASE_YIELD) >= 0 ? PROFIT : LOSS;
    }

    private BigDecimal getTotalWinningMoney() {
        return BigDecimal.valueOf(lottoResult.entrySet().stream()
                                          .mapToInt(this::getWinningMoney)
                                          .sum());
    }

    private int getWinningMoney(Map.Entry<Rank, Integer> entry) {
        return entry.getKey().getWinningMoney() * entry.getValue();
    }
}
