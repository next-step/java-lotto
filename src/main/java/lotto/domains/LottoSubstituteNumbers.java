package lotto.domains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSubstituteNumbers {
    private static final List<Integer> lottoSubstituteNumbers = new ArrayList<>();
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoSubstituteNumbers.add(i);
        }
    }
    public static List<Integer> sixLottoNumbers() {
        Collections.shuffle(lottoSubstituteNumbers);
        return Collections.unmodifiableList(lottoSubstituteNumbers.subList(0,6));
    }
}
