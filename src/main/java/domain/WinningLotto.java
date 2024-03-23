package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Ranks ranks(Lottos lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(lotto.rank(this));
        }
        return new Ranks(ranks);
    }

    public Rank rank(LottoNumbers lottoNumbers) {
        if (lottoNumbers.isMatchFiveNumberAndBonusNumber(winningNumbers, bonusNumber)) {
            return Rank.SECOND;
        }
        return Rank.of(lottoNumbers.matchCount(winningNumbers));
    }
}
