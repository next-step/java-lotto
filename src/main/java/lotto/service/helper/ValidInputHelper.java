package lotto.service.helper;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ValidInputHelper {
    public static <T> T get(Supplier<T> supplier, Consumer<RuntimeException> consumer) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            consumer.accept(e);
            return get(supplier, consumer);
        }
    }
}
