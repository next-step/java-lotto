package lotto.domain;

import java.util.Set;

public class WinnerLotto {
    private static final int SECOND_CANDIDATE_MATCH_NUMBERS = 5;
    private static final boolean DEFAULT_FALSE_BONUS_NUMBER = false;
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinnerLotto(Lotto lotto, LottoNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {
        if(lotto.contains(bonusNumber)){
            throw new IllegalArgumentException("로또번호와 보너스 번호가 중복입니다. bonusNumber : " + bonusNumber.getLottoNumber());
        }
    }

    public Award drawLotto(Set<LottoNumber> lottoNumbers) {
        long matchNumbers = lotto.countContains(lottoNumbers);
        if (matchNumbers == SECOND_CANDIDATE_MATCH_NUMBERS) {
            return Award.findBy(matchNumbers, lottoNumbers.contains(bonusNumber));
        }
        return Award.findBy(matchNumbers, DEFAULT_FALSE_BONUS_NUMBER);
    }
}
