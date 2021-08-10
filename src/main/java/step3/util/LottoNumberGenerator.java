package step3.util;

import step3.domain.lotto.LottoNumber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {
    }

    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    public static List<LottoNumber> create() {
        if (LOTTO_NUMBERS.isEmpty()) {
            createLottoNumbers();
        }

        Collections.shuffle(LOTTO_NUMBERS);
        List<LottoNumber> numbers = new ArrayList<>(LOTTO_NUMBERS.subList(0, 6));
        numbers.sort(Comparator.comparing(LottoNumber::getNumber));
        return numbers;

    }

    private static void createLottoNumbers() {
        for (int i = 1; i < 46; i++) {
            LOTTO_NUMBERS.add(new LottoNumber(i));
        }
    }
}
