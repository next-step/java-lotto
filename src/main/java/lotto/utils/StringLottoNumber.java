package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class StringLottoNumber {
    private static final String DELIMITER = ", ";

    private StringLottoNumber() {
        throw new IllegalArgumentException("util class");
    }

    public static List<LottoNumber> toList(String stringLottoNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String lottoNumber : stringLottoNumbers.split(DELIMITER)) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }
        return lottoNumbers;

    }
}
