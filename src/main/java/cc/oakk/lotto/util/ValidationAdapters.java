package cc.oakk.lotto.util;

public class ValidationAdapters {
    public static<T> T throwIfNull(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Given object is null.");
        }
        return obj;
    }
}
