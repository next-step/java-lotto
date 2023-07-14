package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(final List<LottoNumber> lottoNumbers) {
        validateLottoNumberLength(lottoNumbers);
        validateDuplicateLottoNumber(lottoNumbers);
    }

    private void validateLottoNumberLength(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_LENGTH + "개이여야 합니다");
        }
    }

    private void validateDuplicateLottoNumber(final List<LottoNumber> lottoNumbers) {
        long distinctLength = lottoNumbers.stream()
                .distinct()
                .count();
        if (lottoNumbers.size() != distinctLength) {
            throw new IllegalArgumentException("로또 넘버는 중복되면 안됩니다.");
        }
    }

    public boolean isContain(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }
}
