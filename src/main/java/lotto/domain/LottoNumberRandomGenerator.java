package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class LottoNumberRandomGenerator {

    private LottoNumberRandomGenerator() {
    }

    public static LottoNumbers generate() {
        List<LottoNumber> shuffleNumbers = new ArrayList<>(LottoNumber.LOTTO_NUMBERS);
        Collections.shuffle(shuffleNumbers);
        LottoNumbers subList = LottoNumbers.of(shuffleNumbers.subList(0, 6));

        return subList;
    }
}
