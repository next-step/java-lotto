package lotto.util;

import lotto.exception.InvalidNumberBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberGenerateUtilTest {

    @Test
    @DisplayName("숫자 생성 시 양의 정수만 반환")
    void returnIntegerSetSizeSix() {
        Set<Integer> integers = NumberGenerateUtil.generateNumbers(100, 99);
        assertThat(integers).isNotEmpty().allMatch(i -> i > 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:5", "5:6"}, delimiter = ':')
    @DisplayName("범위가 사이즈보다 같거나 작을 시에 InvalidNumberBoundException 발생")
    void throwInvalidNumberBoundExceptionTest(int bound, int size) {
        assertThatThrownBy(() -> NumberGenerateUtil.generateNumbers(bound, size))
                .isInstanceOf(InvalidNumberBoundException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("size 개수 만큼 숫자 생성")
    void returnIntegerSetSizeSi(int size) {
        Set<Integer> integers = NumberGenerateUtil.generateNumbers(10, size);
        assertThat(integers).hasSize(size);
    }
}