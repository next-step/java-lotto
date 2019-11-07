package lotto.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/07.
 */
@DisplayName("유효성")
class NumbersValidatorTest {

    private static final int NUMBERS_MIN = 1;
    private static final int NUMBERS_MAX = 5;
    private static final int NUMBERS_SIZE = 5;
    private static List<Integer> numbers;

    @BeforeAll
    static void setUp() {
        // given
        numbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    @DisplayName("검사 성공: 범위")
    @Test
    void validRangeSuccess() {
        // when
        boolean result = NumbersValidator.validateRange(numbers, NUMBERS_MIN, NUMBERS_MAX);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("검사 실패: 범위")
    @Test
    void validRangeFail() {
        // when
        boolean result = NumbersValidator.validateRange(numbers, NUMBERS_MIN, NUMBERS_MAX - 1);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("검사 성공: 크기")
    @Test
    void validSizeSuccess() {
        // when
        boolean result = NumbersValidator.validateSize(numbers, NUMBERS_SIZE);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("검사 실패: 크기")
    @Test
    void validSizeFail() {
        // when
        boolean result = NumbersValidator.validateSize(numbers, NUMBERS_SIZE + 1);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("검사 성공: 중복")
    @Test
    void validDuplicateSuccess() {
        // when
        boolean result = NumbersValidator.validateDuplicate(numbers);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("검사 실패: 중복")
    @Test
    void validDuplicateFail() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1);
        // when
        boolean result = NumbersValidator.validateDuplicate(numbers);

        // then
        assertThat(result).isFalse();
    }
}