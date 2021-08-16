package lotto.domain;

import java.util.Set;

public class WinnerLotto {
    private static final int SECOND_CANDIDATE_MATCH_NUMBERS = 5;
    private static final boolean DEFAULT_FALSE_BONUS_NUMBER = false;
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinnerLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Award drawLotto(Set<LottoNumber> lottoNumbers) {
        long matchNumbers = countContains(lottoNumbers);
        if (matchNumbers == SECOND_CANDIDATE_MATCH_NUMBERS) {
            return Award.findBy(matchNumbers, matchBonus(lottoNumbers));
        }
        return Award.findBy(matchNumbers, DEFAULT_FALSE_BONUS_NUMBER);
    }

    private long countContains(Set<LottoNumber> lottoNumbers) {
        return lotto.getNumbers().stream()
                .filter(winnerNumber -> lottoNumbers.contains(winnerNumber))
                .count();
    }

    private boolean matchBonus(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
