package step2.utils;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public abstract class Sets {
    @SafeVarargs
    public static <T> Set<T> of(T... elements) {
        return Stream.of(elements).collect(toSet());
    }
}
