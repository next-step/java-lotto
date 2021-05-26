package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 당첨 결과를 갖고있는 객체
 */
public final class WinningResult {
    public static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "보너스 번호는 당첨번호와 같을 수 없습니다.";
    private final Map<LottoResult, Integer> lottoResultCounts = new HashMap<>();
    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningResult(final Lotto winningLotto, final LottoNumber bonusLottoNumber) {
        validateDuplicatedBonusNumber(winningLotto, bonusLottoNumber);
        initLottoResultCounts();
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void validateDuplicatedBonusNumber(final Lotto winningLotto, final LottoNumber bonusLottoNumber) {
        if (winningLotto.getLottoNumbers()
                .contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
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
        return LottoResult.findByMatchCount(unidentifiedLotto.matchCount(winningLotto),
                unidentifiedLotto.isContains(bonusLottoNumber));
    }
}
