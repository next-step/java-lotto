package lotto.domain;

import java.util.Collection;

public class LottoValidator {

    public static void validLottoNumbers(Collection<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다.");
        }
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("중복되는 숫자 없이 총 6개가 존재해야 합니다.");
        }
    }
}
