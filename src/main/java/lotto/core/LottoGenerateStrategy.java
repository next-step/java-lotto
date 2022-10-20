package lotto.core;

import java.util.List;

public interface LottoGenerateStrategy {

    int MAX_SIZE = 6;
    int LOTTO_MAX_NUM = 46;
    int LOTTO_MIN_NUM = 0;

    List<Integer> generateLotto();
}
