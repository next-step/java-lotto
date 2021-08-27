package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int TOTAL_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoLottoNumbers;

    public Lotto(List<LottoNumber> lottoLottoNumbers) {
        this.lottoLottoNumbers = new ArrayList<>(lottoLottoNumbers);
        validateLottoNumbers(lottoLottoNumbers);
    }

    public Award match(Lotto other) {
        int matchCount = 0;

        for (LottoNumber lottoNumber : lottoLottoNumbers) {
            if (other.lottoLottoNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return Award.valueOf(matchCount);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoLottoNumbers) {
        if (lottoLottoNumbers.size() != TOTAL_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 숫자의 갯수가 6개가 아닙니다.");
        }

        Set<LottoNumber> removeSameLottoNumber = new HashSet<>();
        lottoLottoNumbers.forEach(number -> removeSameLottoNumber.add(number));
        if (removeSameLottoNumber.size() != lottoLottoNumbers.size()) {
            throw new IllegalArgumentException("입력된 숫자가 중복");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoLottoNumbers;
    }
}
