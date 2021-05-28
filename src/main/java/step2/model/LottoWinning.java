package step2.model;

import java.util.List;

public class LottoWinning {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private LottoWinning(Lotto lotto, LottoNumber bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinning of(List<LottoNumber> lottoNumbers, LottoNumber bounusNumber) {
        return new LottoWinning(Lotto.of(lottoNumbers), bounusNumber);
    }

    public LottoRank getRankOfLotto(Lotto lotto) {
        long same = winningLotto.checkWinningCount(lotto);
        boolean matchBonus = lotto.has(bonusNumber);
        return LottoRank.valueOf(same, matchBonus);
    }
}