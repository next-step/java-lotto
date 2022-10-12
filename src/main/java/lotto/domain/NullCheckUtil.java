package lotto.domain;

import lotto.domain.exception.NullCannotBeConstructorArgException;

public class NullCheckUtil {

    private NullCheckUtil() {
    }

    public static void validate(Object object) {
        if (object == null) {
            throw NullCannotBeConstructorArgException.of();
        }
    }
}
