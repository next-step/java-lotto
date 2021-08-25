package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int TOTAL_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoLottoNumbers;

    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoLottoNumbers = new ArrayList<>(lottoGenerator.generateLotto());
        validateLottoNumbers(lottoLottoNumbers);
    }

    public int match(List<LottoNumber> other) {
        int matchCount = 0;

        for (LottoNumber lottoNumber : lottoLottoNumbers) {
            if (other.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoLottoNumbers) {
        if (lottoLottoNumbers.size() != TOTAL_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자의 갯수가 6개가 아닙니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoLottoNumbers;
    }

    @Override
    public String toString() {
        return lottoLottoNumbers.toString();
    }
}
