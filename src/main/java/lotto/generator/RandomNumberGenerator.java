package lotto.generator;

import lotto.domain.LottoMarkingNumbers;
import lotto.domain.LottoNumber;
import lotto.exception.NotSupportInstanceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    private static final int INITIAL_INDEX = 0;

    private RandomNumberGenerator() {
        throw new NotSupportInstanceException();
    }

    public static LottoMarkingNumbers generate() {
        List<LottoNumber> fullLottoNumbers = new ArrayList<>(LottoNumber.cacheValues());
        Collections.shuffle(fullLottoNumbers);
        return new LottoMarkingNumbers(fullLottoNumbers.subList(INITIAL_INDEX, LottoMarkingNumbers.LOTTO_NUMBER_COUNT));
    }
}
