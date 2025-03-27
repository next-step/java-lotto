package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_LENGTH = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLength(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLength(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("lotto size is not 6");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
