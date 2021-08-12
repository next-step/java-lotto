package lotto.domain;

import lotto.domain.exception.WinningNumberDuplicateException;

public final class WinningsStatistics {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningsStatistics(final Lotto winningLotto, final LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final Lotto winningLotto, final LottoNumber bonusNumber) {
        if (winningLotto.hasLottoNumber(bonusNumber)) {
            throw new WinningNumberDuplicateException();
        }
    }

    public Result makeStatisticsWinnings(final Lottos lottos) {
        Result result = new Result();

        for (Lotto lotto : lottos.getLottos()) {
            makeStatisticsWinningsByRank(result, lotto);
        }

        return result;
    }

    private void makeStatisticsWinningsByRank(final Result result, final Lotto lotto) {
        MatchingCount matchingCount = lotto.getMatchingCount(winningLotto);
        boolean isBonus = lotto.hasLottoNumber(bonusNumber);

        Rank rank = Rank.findRank(matchingCount, isBonus);

        result.addHitsCount(rank);
    }

}
