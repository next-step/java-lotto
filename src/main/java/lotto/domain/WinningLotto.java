package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final String ERROR_DISTINCT = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    private static final int MATCH_FIVE = 5;
    private static final int WINNING_LIMIT_MATCH_COUNT = 3;

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningLotto = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.getLotto().contains(bonusNumber.getLottoNumber())) {
            throw new IllegalArgumentException(ERROR_DISTINCT);
        }
    }

    public List<Rank> matchRank(Lottos lottos) {
        List<Rank> winningRanks = new ArrayList<>();
        for(Lotto lotto : lottos.getLottos()) {
            int matchOfNumber = countMatchNumbers(lotto);
            addWinningRanksList(matchOfNumber, lotto, winningRanks);
        }
        return winningRanks;
    }

    private int countMatchNumbers(final Lotto lotto) {
        return lotto.matchWinningLotto(winningLotto);
    }

    private void addWinningRanksList(int matchOfNumber, Lotto lotto, List<Rank> winningRanks) {
        if(matchOfNumber >= WINNING_LIMIT_MATCH_COUNT) {
            winningRanks.add(getRank(matchOfNumber, lotto));
        }
    }

    private Rank getRank(final int count, final Lotto lotto) {
        if (matchBonusNumber(count, lotto)) {
            return Rank.SECOND;
        }
        if(Rank.getRank(count) == Rank.SECOND) {
            return Rank.THIRD;
        }
        return Rank.getRank(count);
    }

    private boolean matchBonusNumber(final int matchOfNumber, final Lotto lottoNumberList) {
        return matchOfNumber == MATCH_FIVE && lottoNumberList.getLotto()
            .contains(bonusNumber);
    }

}
