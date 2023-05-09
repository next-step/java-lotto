package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    private static final int START_NUMBER = 1;
    private static final int LIMIT_NUMBER = 46;
    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public static List<LottoNumber> getLottoNumbers() {
        if (lottoNumbers.isEmpty()) {
            createLottoNumbers();
        }
        return lottoNumbers;
    }

    private static void createLottoNumbers() {
        IntStream.range(START_NUMBER, LIMIT_NUMBER)
                 .forEach(num -> lottoNumbers.add(new LottoNumber(num)));
    }
}
