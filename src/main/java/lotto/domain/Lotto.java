package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {

    public static final long SIZE = 6;
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

    public Award drawLotto(Lotto winnerLotto) {
        return Award.findBy(countContains(winnerLotto));
    }

    public long countContains(Lotto winnerLotto) {
        return winnerLotto.getNumbers().stream()
                .filter(winnerNumber -> this.lottoNumbers.contains(winnerNumber))
                .count();
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }
}
