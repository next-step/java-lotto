package lotto.util;

import lotto.dto.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final List<LottoNumber> LOTTO_NUMBER = new ArrayList<>();

    static {
        for (int number = LOTTO_MIN; number <= LOTTO_MAX; number++) {
            LOTTO_NUMBER.add(new LottoNumber(number));
        }
    };
}
