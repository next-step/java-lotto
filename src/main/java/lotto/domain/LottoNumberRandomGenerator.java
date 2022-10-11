package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberRandomGenerator {

    private LottoNumberRandomGenerator() {
    }

    public static Lotto generate() {
        List<LottoNumber> shuffleNumbers = new ArrayList<>(LottoNumber.LOTTO_NUMBERS);
        Collections.shuffle(shuffleNumbers);
        Lotto subList = Lotto.of(shuffleNumbers.subList(0, 6));

        return subList;
    }
}
