package cc.oakk.lotto.util;

import java.util.Objects;

public class ValidationAdapters {
    private ValidationAdapters() {}

    public static<T> T throwIfNull(T obj) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException("Given object is null.");
        }
        return obj;
    }
}
