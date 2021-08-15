package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    public static final long SIZE = 6;
    public static final int SECOND_CANDIDATE_MATCH_NUMBERS = 5;
    public static final boolean DEFAULT_FALSE_BONUS_NUMBER = false;
    private Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
    }

    private void checkSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException("LottoNumbers의 사이즈가 잘못 입력되었습니다. 입력 사이즈 : " + lottoNumbers.size());
        }
    }

    public Award drawLotto(WinnerLotto winnerLotto) {
        long matchNumbers = countContains(winnerLotto.getLotto());
        if(matchNumbers == SECOND_CANDIDATE_MATCH_NUMBERS) {
            return Award.findBy(matchNumbers, matchBonus(winnerLotto.getBonusNumber()));
        }
        return Award.findBy(matchNumbers, DEFAULT_FALSE_BONUS_NUMBER);
    }

    public long countContains(Lotto winnerLotto) {
        return winnerLotto.getNumbers().stream()
                .filter(winnerNumber -> this.lottoNumbers.contains(winnerNumber))
                .count();
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    private boolean matchBonus(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }
}
