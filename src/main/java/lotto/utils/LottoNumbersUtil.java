package lotto.utils;

import java.util.List;
import java.util.ArrayList;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class LottoNumbersUtil {
    private static final String SPLIT_DELIMITER = ",";

    public static LottoNumbers toLottoNumbers(String textNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : textNumber.split(SPLIT_DELIMITER)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        return new LottoNumbers(lottoNumbers);
    }
}
