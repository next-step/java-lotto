package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final String ERROR_DISTINCT = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    private static final int MATCH_FIVE = 5;
    private static final int WINNING_LIMIT = 3;

    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;
    private List<Rank> winningRanks = new ArrayList<>();
    private final Lottos lottos;

    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber, Lottos lottos) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    private void validate(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.getLottoNumbers().contains(bonusNumber.getLottoNumber())) {
            throw new IllegalArgumentException(ERROR_DISTINCT);
        }
    }

    public List<Rank> matchRank() {
        for(Lotto lotto : lottos.getLottos()) {
            int matchOfNumber = matchWinningNumbers(lotto);
            addWinningRanksList(matchOfNumber, lotto);
        }
        return winningRanks;
    }

    private int matchWinningNumbers(final Lotto lotto) {
        return lotto.matchWinningnumbers(lotto, winningNumber);
    }

    private void addWinningRanksList(int matchOfNumber, Lotto lotto) {
        if(matchOfNumber >= WINNING_LIMIT) {
            winningRanks.add(getRank(matchOfNumber, lotto));
        }
    }

    private Rank getRank(final int count, final Lotto lotto) {
        if (matchBonusNumber(count, lotto)) {
            return Rank.SECOND;
        }
        return Rank.getRank(count);
    }

    private boolean matchBonusNumber(final int matchOfNumber, final Lotto lottoNumberList) {
        return matchOfNumber == MATCH_FIVE && lottoNumberList.getLottoNumbers()
            .contains(bonusNumber);
    }

}
