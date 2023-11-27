package lotto.domain;

import java.util.List;

public class Lotto {
    public static final Integer PRICE = 1000;
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> lotto() {
        return lotto;
    }

    public int matchingCount(Lotto winningLotto) {
        int matchingCount = 0;
        for (int number : winningLotto.lotto()) {
            matchingCount = increaseMatchingCount(matchingCount, number);
        }
        return matchingCount;
    }

    private int increaseMatchingCount(int matchingCount, int number) {
        if (lotto.contains(number)) {
            matchingCount++;
        }
        return matchingCount;
    }
}
