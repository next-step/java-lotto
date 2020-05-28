package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final List<Integer> LOTTO_NUMBERS= new ArrayList<>();

    private LottoNumbers() {
    }

    public static List<Integer> getLottoNumbers() {
        for (int i = 1; i <= 45 ; i++) {
            LOTTO_NUMBERS.add(i);
        }

        return LOTTO_NUMBERS;
    }
}
