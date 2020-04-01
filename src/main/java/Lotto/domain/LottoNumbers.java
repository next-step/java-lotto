package Lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoNumbers {
    public static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumberSet;

    public LottoNumbers(final Set<LottoNumber> lottoNumberSet) {
        validateLottoSize(lottoNumberSet);
        this.lottoNumberSet = new HashSet<>(lottoNumberSet);
    }

    private void validateLottoSize(final Set<LottoNumber> lottoNumberSet) {
        final int lottoSize = lottoNumberSet.size();
        if (lottoSize != LOTTO_SIZE) {
            throw new IllegalArgumentException("Size of Lotto is wrong: " + lottoSize);
        }
    }

    public boolean contains(LottoNumber number) {
        return this.lottoNumberSet.contains(number);
    }
}
