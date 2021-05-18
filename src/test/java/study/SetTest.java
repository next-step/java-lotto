package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set size 확인")
    @Test
    void checkSetSize() {
        //then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("Set contains 확인(true만 포함)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsOnlyTrue(int setNumbers) {
        //then
        assertThat(numbers.contains(setNumbers)).isTrue();
    }

    @DisplayName("Set contains 확인(true, false 포함)")
    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    void containsBothTrueAndFalse(int num, boolean isContains) {
        //then
        assertEquals(numbers.contains(num), isContains);
    }
}
