package lotto.domain;
import java.util.function.Function;

class ThrowableFunctionWrapper {
    public static Function wrapper(ThrowableFunctionalInterface function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        };
    }
}

