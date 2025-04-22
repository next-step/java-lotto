package Lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LottoGenerator {
    private static final List<LottoNumber> candidates = new ArrayList<>();

    static {
        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i <= LottoNumber.LOTTO_MAX_NUMBER; i++) {
            candidates.add(LottoNumber.of(i));
        }
    }

    public static Lotto auto() {
        List<LottoNumber> copy = new ArrayList<>(candidates);
        Collections.shuffle(copy);
        return new Lotto(copy.subList(0, Lotto.LOTTO_PICK_COUNT));
    }

    public static Lotto manual(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }
}
