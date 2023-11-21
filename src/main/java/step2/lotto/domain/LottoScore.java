package step2.lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoScore {

    private final Map<LottoRank, Integer> lottoScore;

    public LottoScore() {
        this.lottoScore = createLottoScore();
    }

    public Map<LottoRank, Integer> getLottoScore() {
        return Collections.unmodifiableMap(lottoScore);
    }

    private Map<LottoRank, Integer> createLottoScore() {
        Map<LottoRank, Integer> lottoScore = new HashMap<>();
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> lottoScore.put(lottoRank, 0));
        return lottoScore;
    }

    public void recordMatchLotto(final Lottos lottos, final LottoWinNumberInfo winNumberInfo) {
        lottos.getLottos().stream().forEach(lotto -> {
            LottoRank lottoRank = LottoRank.matchLottoRank(winNumberInfo.matchCount(lotto));
            lottoScore.merge(lottoRank, 1, Integer::sum);
        });
    }

    public double calculateProfitRatio(final LottoPurchaseInfo purchaseInfo) {
        return calculateTotalPrizeAmount() / purchaseInfo.getLottoPurchaseMoney();
    }

    private long calculateTotalPrizeAmount() {
        return Arrays.stream(LottoRank.values())
            .mapToLong(lottoRank -> lottoRank.lottoRankTotalPrizeAmount(lottoScore.get(lottoRank)))
            .sum();
    }

}
