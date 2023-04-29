package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static List<Integer> LOTTO_NUMBERS =
            Collections.unmodifiableList(getLottoNumbers());

    public static LottoNumbers generate() {
        List<Integer> copy = new ArrayList<>(List.copyOf(LOTTO_NUMBERS));
        Collections.shuffle(copy);

        List<Integer> lottoNumbers = copy.subList(0, 6);
        return new LottoNumbers(lottoNumbers);
    }

    private static List<Integer> getLottoNumbers() {
        LOTTO_NUMBERS = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_MIN; i <= LottoNumber.LOTTO_MAX; i++) {
            LOTTO_NUMBERS.add(i);
        }
        return LOTTO_NUMBERS;
    }
}
