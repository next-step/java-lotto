package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lottos {

    private static final int MINIMUM_RANK = 3;
    private static final int FOUR_NUMBERS_MATCHING = 4;

    private final LottoResult lottoResult = new LottoResult();

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos, int autoTicketCount) {
        for (int i = 0; i < autoTicketCount; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    public void calculateLottoResult(Lotto winningNumbers, LottoNumber bonusBall, PaidAmount paidAmount) {
        for (Lotto lotto : this.lottos) {
            checkMinimumMatching(lotto, winningNumbers, bonusBall);
        }
        lottoResult.calculatePrizeRate(paidAmount);
    }

    private void checkMinimumMatching(Lotto lotto, Lotto winningNumbers, LottoNumber bonusBall) {
        int matchingCount = lotto.match(winningNumbers);

        if (matchingCount >= MINIMUM_RANK) {
            lottoResult.addWinningResult(getMatchingRank(lotto, matchingCount, bonusBall));
        }
    }

    private Rank getMatchingRank(Lotto lotto, int matchingCount, LottoNumber bonusBall) {
        if (matchingCount == FOUR_NUMBERS_MATCHING) {
            return checkBonusBall(lotto, bonusBall);
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatch() == matchingCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private Rank checkBonusBall(Lotto lotto, LottoNumber bonusBall) {
        if (lotto.isMatch(bonusBall)) {
            return Rank.BONUS;
        }
        return Rank.THIRD;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult getLottoResult() {
        return this.lottoResult;
    }
}
