package cc.oakk.lotto.util;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ValidationAdapters {
    private ValidationAdapters() {}

    public static int throwIfNegative(int number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static int throwIfNegative(int number) {
        return throwIfNegative(number, "Given number is negative.");
    }

    public static<T> T throwIfNull(T obj) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException("Given object is null.");
        }
        return obj;
    }

	public static<T> T tryUntilSuccess(Supplier<T> supplier, Consumer<Throwable> onError) {
        try {
            return supplier.get();
        } catch (Exception e) {
            onError.accept(e);
            return tryUntilSuccess(supplier, onError);
        }
    }
}
