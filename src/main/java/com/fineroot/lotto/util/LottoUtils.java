package com.fineroot.lotto.util;

import static com.fineroot.lotto.util.ExceptionMessage.UTILITY_CLASS;

public class LottoUtils {
    private LottoUtils(){
        throw new IllegalArgumentException(UTILITY_CLASS.getMessage());
    }

    public static final int LOTTO_EACH_PRICE = 1_000;
}
