package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoGenerator {

    int LOTTO_START_NUMBER = 1;
    int LOTTO_END_NUMBER = 45;

    List<Integer> generate();
}
