package lotto.utils;

import java.util.function.Supplier;

public class ConvertUtil {

    public static <T extends Throwable> int toIntOrThrow(String input, Supplier<? extends T> exceptionSupplier) throws T {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw exceptionSupplier.get();
        }
    }
}
