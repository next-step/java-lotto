package step2.utils;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

public class SetsTest {
    @Test
    void staticFactoryMethod() {
        assertThat(Sets.of(1, 2, 3, 4)) //
                .isInstanceOf(Set.class) //
                .containsExactly(1, 2, 3, 4);
    }

    public abstract static class Sets {
        @SafeVarargs
        public static <T> Set<T> of(T... elements) {
            return Stream.of(elements).collect(toSet());
        }

    }
}
