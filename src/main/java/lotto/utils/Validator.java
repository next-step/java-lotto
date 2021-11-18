package lotto.utils;

import java.util.Objects;

public class Validator {

    private Validator() {
    }

    public static void checkNotNull(Object... objects) {
        for (Object object : objects) {
            checkNotNull(object);
        }
    }

    public static void checkNotNull(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("필수 값이 없습니다.");
        }
    }
}
