package humbledude.lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoNumberSet {
    public static final int LOTTO_SIZE_OF_NUMBERS = 6;

    private final Set<LottoNumber> lottoNumberSet;

    public LottoNumberSet(Set<LottoNumber> lottoNumberSet) {
        validateSet(lottoNumberSet);
        this.lottoNumberSet = lottoNumberSet;
    }

    public Set<LottoNumber> getNumbers() {
        return lottoNumberSet;
    }

    public Set<LottoNumber> intersection(LottoNumberSet other) {
        Set<LottoNumber> copy = new HashSet<>(this.getNumbers());
        copy.retainAll(other.getNumbers());

        return copy;
    }

    private void validateSet(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("로또는 겹치지 않는 6개 숫자로만 만들수 있어요");
        }
    }
}
