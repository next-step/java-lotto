package lotto;

import java.util.List;

public class LottoGame {

    public static int match(List<Integer> lotto, List<Integer> winningLotto) {
        return (int) lotto.stream()
                .filter(num -> winningLotto.contains(num))
                .count();
    }
}
