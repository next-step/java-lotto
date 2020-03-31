package lotto;

import java.util.List;

public class LottoGame {

    public static final int FOURTH = 4;
    public static final int THIRD = 3;
    public static final int SECOND = 2;
    public static final int FIRST = 1;

    public static int match(List<Integer> lotto, List<Integer> winningLotto) {
        return (int) lotto.stream()
                .filter(num -> winningLotto.contains(num))
                .count();
    }

    public static int getRank(int matchCount) {
        if (matchCount == 3) {
            return FOURTH;
        }
        if (matchCount == 4) {
            return THIRD;
        }
        if (matchCount == 5) {
            return SECOND;
        }
        if (matchCount == 6) {
            return FIRST;
        }

        return 0;
    }
}
