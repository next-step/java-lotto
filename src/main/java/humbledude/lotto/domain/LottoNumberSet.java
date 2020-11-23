package humbledude.lotto.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public boolean contains(LottoNumber number) {
        return lottoNumberSet.contains(number);
    }

    public Set<LottoNumber> intersection(LottoNumberSet other) {
        return lottoNumberSet.stream()
                .filter(other::contains)
                .collect(Collectors.toSet());
    }

    private void validateSet(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("로또는 겹치지 않는 6개 숫자로만 만들수 있어요");
        }
    }
}
