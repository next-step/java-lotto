package dev.dahye.learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Collections 객체 학습 테스트")
public class CollectionsTest {
    @Test
    @DisplayName("contains() 메소드 학습 테스트 - return true")
    void contains_true() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> comparedNumbers = Arrays.asList(1, 2);

        for (Integer number : comparedNumbers) {
            assertTrue(numbers.contains(number));
        }
    }

    @Test
    @DisplayName("contains() 메소드 학습 테스트 - return false")
    void contains_false() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> comparedNumbers = Arrays.asList(4, 5);

        for (Integer number : comparedNumbers) {
            assertFalse(numbers.contains(number));
        }
    }
}
