package lotto.validator;

import lotto.domain.LottoNumber;

import java.util.List;

import static lotto.domain.Lotto.SIZE;

public class LottoValidator {
    public static void checkDistinct(List<LottoNumber> lotto) {
        int compareSize = Long.valueOf(lotto.stream()
                .distinct()
                .count()).intValue();
        if (compareSize != lotto.size()) {
            throw new IllegalArgumentException("로또에 중복된 숫자가 존재합니다.");
        }
    }

    public static void checkSize(List<LottoNumber> lottoLottoNumbers) {
        if (lottoLottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
        }
    }

}
