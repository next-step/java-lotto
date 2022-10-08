package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class ExtractStrategy {
    protected int MAX_LOTTO_NUM = 45;

    protected static final List<Integer> baseNumbers = new ArrayList<>();

    public ExtractStrategy() {
        for (int i = 1; i <= MAX_LOTTO_NUM; i++) {
            baseNumbers.add(i);
        }
    }
    public abstract List<Integer> extractNumber(int number);
}
