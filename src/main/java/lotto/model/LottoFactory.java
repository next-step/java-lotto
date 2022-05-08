package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.model.LottoNumber.MAX_VALUE;
import static lotto.model.LottoNumber.MIN_VALUE;

public final class LottoFactory {

    private static final int LOTTO_MAX_COUNT = 6;
    private static final int LOTTO_START_INDEX = 0;

    private static final List<Integer> init = init();


    public static Lotto apply() {
        Collections.shuffle(init);
        return new Lotto(new HashSet<>(init.subList(LOTTO_START_INDEX, LOTTO_MAX_COUNT)));
    }

    private static List<Integer> init() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }
}
