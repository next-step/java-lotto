package util;

import lotto.domain.WinningAmount;

public class CommonException {

    public static void RuntimeException(String message) {
        throw new RuntimeException(message);
    }
    public static void IllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }
}
