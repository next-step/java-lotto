package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_UNIT_NUMBER = 6;
    public static final int LOTTO_ALL_NUMBER = 45;
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int COUNT_INITIAL_VALUE = 0;

    private List<Integer> lotto = new ArrayList<>();

    public Lotto() {
        List<Integer> lottoNumber = new ArrayList<>();
        for (int i = LOTTO_MINIMUM_NUMBER; i <= LOTTO_ALL_NUMBER; i++) {
            lottoNumber.add(i);
        }
        Collections.shuffle(lottoNumber);

        for (int i = 0; i < LOTTO_UNIT_NUMBER; i++) {
            lotto.add(lottoNumber.get(i));
        }
        Collections.sort(lotto);

    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public int numberOfSame(Lotto lotto) {
        int count = COUNT_INITIAL_VALUE;
        for (int i = 0; i < LOTTO_UNIT_NUMBER; i++) {
            count = numberOfSameLotto(lotto, i, count);
        }
        return count;
    }

    private int numberOfSameLotto(Lotto lotto, int index, int count) {
        if (this.lotto.contains(lotto.lotto.get(index))) {
            return ++count;
        }
        return count;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
