package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberRandomGenerator {

    private LottoNumberRandomGenerator() {
    }

    public static List<LottoNumber> generate() {
        List<LottoNumber> numbers = LottoNumber.LOTTO_NUMBERS;
        Collections.shuffle(numbers);
        List<LottoNumber> subList = numbers.subList(0, 6);

        return subList;
    }
}
