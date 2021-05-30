package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class LottoNumbersUtil {
    private static final String SPLIT_DELIMITER = ",";
    private static final int NO_COUNT = 0;

    public static LottoNumbers toLottoNumbers(String textNumber) {
        validateEmptyOrNull(textNumber);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : textNumber.split(SPLIT_DELIMITER)) {
            lottoNumbers.add(LottoNumber.of(number.trim()));
        }
        validateLottoNumbersSize(lottoNumbers);
        validateDuplicatedNumber(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static void validateEmptyOrNull(String textNumber) {
        if (textNumber == null || textNumber.isEmpty() || textNumber.split(SPLIT_DELIMITER).length == NO_COUNT) {
            throw new IllegalArgumentException("입력된 로또번호가 없습니다.");
        }
    }

    private static void validateLottoNumbersSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoNumbers.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또번호 개수가 부족하거나 초과하였습니다.");
        }
    }

    private static void validateDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> result = new HashSet<>(lottoNumbers);
        if (result.size() != LottoNumbers.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또는 중복되는 번호를 가질 수 없습니다.");
        }
    }
}
