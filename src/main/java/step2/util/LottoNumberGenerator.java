package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {
    }

    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    public static List<Integer> create() {
        if (LOTTO_NUMBERS.isEmpty()) {
            createLottoNumbers();
        }

        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS.subList(0, 6));
        numbers.sort(Comparator.naturalOrder());
        return numbers;

    }

    private static void createLottoNumbers() {
        for (int i = 1; i < 46; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }
}
