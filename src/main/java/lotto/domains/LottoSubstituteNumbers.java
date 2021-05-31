package lotto.domains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSubstituteNumbers {
    private static final List<LottoNumber> LOTTO_SUBSTITUTE_NUMBERS = new ArrayList<>();
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_NUMBER_FROM_INDEX = 0;
    private static final int LOTTO_NUMBER_TO_INDEX = 6;

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            LOTTO_SUBSTITUTE_NUMBERS.add(LottoNumber.of(i));
        }
    }

    public static List<LottoNumber> sixLottoNumbers() {
        Collections.shuffle(LOTTO_SUBSTITUTE_NUMBERS);
        return Collections.unmodifiableList(LOTTO_SUBSTITUTE_NUMBERS.subList(LOTTO_NUMBER_FROM_INDEX, LOTTO_NUMBER_TO_INDEX));
    }
}
