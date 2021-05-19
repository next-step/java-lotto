package step1;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

    private Set<Integer> numbers;

    @SuppressWarnings("OverwrittenKey")
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set collection 크기 검증")
    @Test
    void sizeTest() {
        assertEquals(3, numbers.size());
    }

    @DisplayName("값 포함 여부 검증 - 1")
    @MethodSource("containsTestCase01")
    @ParameterizedTest
    void containsTest01(int number) {
        assertTrue(numbers.contains(number));
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> containsTestCase01() {
        return Stream.iterate(1, i -> i + 1)
                     .limit(3)
                     .map(Arguments::of);
    }

    @DisplayName("값 포함 여부 검증 - 2")
    @MethodSource("containsTestCase02")
    @ParameterizedTest
    void containsTest01(int number, boolean expected) {
        assertEquals(expected, numbers.contains(number));
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> containsTestCase02() {
        return Stream.iterate(0, i -> i + 1)
                     .limit(10)
                     .map(i -> Arguments.of(i, (i >= 1 && i <= 3)));
    }
}
