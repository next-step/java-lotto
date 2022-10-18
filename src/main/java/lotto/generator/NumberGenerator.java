package lotto.generator;

import lotto.domain.LottoNumber;

import java.util.List;

public interface NumberGenerator {
    public static final int MIN_LOTTO_NUM_COUNT = 0;
    public static final int MAX_LOTTO_NUM_COUNT = 6;

    public List<LottoNumber> generate();

}
