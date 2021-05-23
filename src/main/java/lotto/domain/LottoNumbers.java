package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    public static final int LOTTO_NUMBERS_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumbersSize(lottoNumbers);
        validateDuplicatedNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumber getLottoNumber(int index) {
        return this.lottoNumbers.get(index);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public boolean isEmpty() {
        return this.lottoNumbers.isEmpty();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }

    private void validateLottoNumbersSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또번호 개수가 부족하거나 초과하였습니다.");
        }
    }

    private void validateDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> result = new HashSet<>(lottoNumbers);
        if (result.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또는 중복되는 번호를 가질 수 없습니다.");
        }
    }
}
