package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningsStatistics {

    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "당첨번호와 보너스번호가 중복되었습니다.";
    private static final int INIT = 0;

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningsStatistics(final Lotto winningLotto, final LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final Lotto winningLotto, final LottoNumber bonusNumber) {
        if (winningLotto.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    public EnumMap<Rank, MatchingCount> makeStatisticsWinningsByRank(final Lottos lottos) {
        EnumMap<Rank, MatchingCount> winnings = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos.getLottos()) {
            makeStatisticsWinningsByRank(winnings, lotto);
        }

        return winnings;
    }

    private void makeStatisticsWinningsByRank(EnumMap<Rank, MatchingCount> winnings, final Lotto lotto) {
        MatchingCount matchingCount = lotto.getMatchingCount(winningLotto);

        boolean matchBonus = lotto.addMatchingCount(bonusNumber);

        Rank rank = Rank.returnRank(matchingCount, matchBonus);

        winnings.put(rank, new MatchingCount(winnings.getOrDefault(rank, new MatchingCount()).getValue()).increment());
    }

    public double calculateEarningsRate(final Map<Rank, MatchingCount> winnings, final int totalCount) {
        int totalPrize = INIT;

        for (Rank rank : winnings.keySet()) {
            totalPrize += rank.totalWinningMoney(winnings.get(rank));
        }

        return Math.round((float) totalPrize / (totalCount * 10)) / 100.0;
    }

}
