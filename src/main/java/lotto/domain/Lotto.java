package lotto.domain;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_LENGTH = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this(new HashSet<>(lottoNumbers.stream().map(LottoNumber::new).collect(toSet())));
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        checkValid(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public int matchCount(Lotto lotto) {
        int count = 0;

        for (LottoNumber winNumber : lotto.lottoNumbers) {
            count += isMatch(winNumber) ? 1 : 0;
        }

        return count;
    }

    public boolean isMatch(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void checkValid(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("lotto size is not 6");
        }
    }
}
