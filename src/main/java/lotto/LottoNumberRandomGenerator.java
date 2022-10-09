package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberRandomGenerator {

    private LottoNumberRandomGenerator() {
    }

    public static List<LottoNumber> generate() {
        ArrayList<LottoNumber> shuffleNumbers = new ArrayList<>(LottoNumber.LOTTO_NUMBERS);
        Collections.shuffle(shuffleNumbers);
        List<LottoNumber> subList = shuffleNumbers.subList(0, 6);

        return subList;
    }
}
