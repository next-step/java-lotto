package lotto.utils;

import java.util.Objects;

public class Validator {

    public static final String REQUIRED_ERROR_MESSAGE = "필수 값이 없습니다.";

    private Validator() {
    }

    public static void checkNotNull(Object... objects) {
        for (Object object : objects) {
            checkNotNull(object);
        }
    }

    public static void checkNotNull(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(REQUIRED_ERROR_MESSAGE);
        }
    }
}
