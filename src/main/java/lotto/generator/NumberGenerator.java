package lotto.generator;

import lotto.domain.LottoNumber;

import java.util.List;

public interface NumberGenerator {
    public static final int MIN_LOTTO_NUM = 0;
    public static final int MAX_LOTTO_NUM = 6;

    List<LottoNumber> generate();

}
