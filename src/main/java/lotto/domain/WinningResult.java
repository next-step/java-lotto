package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 당첨 결과를 갖고있는 객체
 */
public final class WinningResult {
    private final Map<LottoResult, Integer> lottoResultCounts = new HashMap<>();
    private final Lotto winningLotto;

    public WinningResult(final Lotto winningLotto) {
        initLottoResultCounts();
        this.winningLotto = winningLotto;
    }

    private void initLottoResultCounts() {
        for (int i = 0; i < LottoResult.values().length; i++) {
            lottoResultCounts.put(LottoResult.values()[i], 0);
        }
    }

    public void addLottoResult(final LottoResult lottoResult) {
        lottoResultCounts.computeIfPresent(lottoResult, (lottoResultKey, count) -> ++count);
    }

    public double getProfitRate(final Money purchasedMoney) {
        return (double) getTotalReward() / purchasedMoney.getMoney();
    }

    private int getTotalReward() {
        return lottoResultCounts.keySet()
                .stream()
                .mapToInt(this::getReward)
                .sum();
    }

    private int getReward(final LottoResult lottoResult) {
        return lottoResultCounts.get(lottoResult) * lottoResult.getReward();
    }

    public Map<LottoResult, Integer> getLottoResultCounts() {
        return lottoResultCounts;
    }

    public void matchWinningLotto(final List<Lotto> purchasedLottos) {
        for (final Lotto lotto : purchasedLottos) {
            addLottoResult(getLottoResult(lotto));
        }
    }

    private LottoResult getLottoResult(final Lotto unidentifiedLotto) {
        return LottoResult.findByMatchCount(winningLotto.matchCount(unidentifiedLotto));
    }
}
