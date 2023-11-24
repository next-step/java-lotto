package step2.lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoScore {

    private final Map<LottoRank, Integer> lottoScore;

    private LottoScore() {
        this.lottoScore = initLottoScore();
    }

    public Map<LottoRank, Integer> getLottoScore() {
        return Collections.unmodifiableMap(lottoScore);
    }

    public static LottoScore create() {
        return new LottoScore();
    }

    private Map<LottoRank, Integer> initLottoScore() {
        Map<LottoRank, Integer> lottoScore = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> lottoScore.put(lottoRank, 0));
        return lottoScore;
    }

    public void recordMatchLotto(final Lottos lottos, final LottoWin lottoWin) {
        lottos.getLottos().stream().forEach(lotto -> {
            LottoRank lottoRank =
                LottoRank.valueOf(lottoWin.matchCount(lotto), lottoWin.matchBonusNumber(lotto));
            lottoScore.merge(lottoRank, 1, Integer::sum);
        });
    }

    public double calculateProfitRatio(final LottoPurchase purchaseInfo) {
        return calculateTotalPrizeAmount() / purchaseInfo.getLottoPurchaseMoney();
    }

    private long calculateTotalPrizeAmount() {
        return Arrays.stream(LottoRank.values())
            .mapToLong(lottoRank -> lottoRank.lottoRankTotalPrizeAmount(lottoScore.get(lottoRank)))
            .sum();
    }

}
