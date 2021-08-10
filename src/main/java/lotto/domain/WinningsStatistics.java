package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class WinningsStatistics {

    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "당첨번호와 보너스번호가 중복되었습니다.";
    private static final int INIT = 0;
    private static final int LOTTO_PRICE = 1000;

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningsStatistics(final Lotto winningLotto, final LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final Lotto winningLotto, final LottoNumber bonusNumber) {
        if (winningLotto.hasLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<Result> makeStatisticsWinnings(final Lottos lottos) {
        List<Result> results = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            results.add(new Result(rank, INIT));
        }

        for (Lotto lotto : lottos.getLottos()) {
            makeStatisticsWinningsByRank(results, lotto);
        }

        return results;
    }

    private void makeStatisticsWinningsByRank(final List<Result> results, final Lotto lotto) {
        MatchingCount matchingCount = lotto.getMatchingCount(winningLotto);

        boolean matchBonus = lotto.hasLottoNumber(bonusNumber);

        Rank rank = Rank.returnRank(matchingCount, matchBonus);

        for (Result result : results) {
            result.addHitsCount(rank);
        }
    }

    public double calculateEarningsRate(final List<Result> results, final int totalCount) {
        int totalPrize = INIT;

        for (Result result : results) {
            totalPrize += result.calculateTotalWinningMoney();
        }

        return (double) totalPrize / (totalCount * LOTTO_PRICE);
    }

}
