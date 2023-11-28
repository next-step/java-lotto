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
        return (int) winningLotto.lotto()
                .stream()
                .filter(lotto::contains)
                .count();
    }

    private int increaseMatchingCount(int matchingCount, int number) {
        if (lotto.contains(number)) {
            matchingCount++;
        }
        return matchingCount;
    }

    public Ranking ranking(WinningLotto winningLotto) {
        int matchingCount = (int) lotto.stream().filter(winningLotto.lotto().lotto()::contains).count();
        boolean hasBonusNumber = lotto.contains(winningLotto.bonusNumber());
        return Ranking.of(matchingCount, hasBonusNumber);
    }
}
