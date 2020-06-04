package dev.dahye.learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Collections 객체 학습 테스트")
public class CollectionsTest {
    private static final List<Integer> comparedList = Arrays.asList(1, 2, 3);

    @ParameterizedTest(name = "comparedList에 포함되어 있는 번호 {0}는 true를 반환한다.")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains() 메소드 학습 테스트 - return true")
    void contains_true(int targetNumber) {
        assertTrue(comparedList.contains(targetNumber));
    }

    @ParameterizedTest(name = "comparedList에 포함되어 있지 않은 번호 {0}는 false를 반환한다.")
    @ValueSource(ints = {4, 5})
    @DisplayName("contains() 메소드 학습 테스트 - return false")
    void contains_false(int targetNumber) {
        assertFalse(comparedList.contains(targetNumber));
    }
}
