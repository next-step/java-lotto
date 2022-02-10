package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(final List<LottoNumber> winningNumbers, final LottoNumber bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public Ranking matchLotto(final Lotto lotto) {
        final LottoResult result = new LottoResult(0, false);
        final LottoResult lottoResult = result.countLotteryNumber(winningNumbers, lotto.getLottoNumbers(),
            bonusBall);

        return Ranking.judgeRanking(lottoResult);
    }
}
