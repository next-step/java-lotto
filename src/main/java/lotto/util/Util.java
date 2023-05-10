package lotto.util;

import lotto.domain.LottoConstant;

public class Util {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static int convertInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(LottoConstant.ILLEGAL_LOTTO_NUMBER);
        }
    }
}
