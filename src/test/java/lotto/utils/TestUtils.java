package lotto.utils;

import lotto.LottoNumber;
import lotto.LottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public static LottoNumbers testLottoNumbers() {
        return new LottoNumbers(
                Arrays.asList(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)));
    }

    public static LottoNumbers testLottoNumbers(int... numbers) {

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number: numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new LottoNumbers(lottoNumbers);
    }
}
