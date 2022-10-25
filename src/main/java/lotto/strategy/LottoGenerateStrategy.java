package lotto.strategy;

import java.util.Set;

public interface LottoGenerateStrategy {

    int MAX_SIZE = 6;
    int LOTTO_MAX_BOUND_NUM = 46;
    int LOTTO_MIN_NUM = 1;

    Set<Integer> generateLotto();
}
