package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NumbersTest {
    private Numbers numbers;

    @BeforeEach
    void initNumbers() {
        numbers = new Numbers();
    }

    @Test
    @DisplayName("빈 문자열, null 값 입력 테스트")
    void emptyNullInput_ShouldBeZero() {
        assertThat(numbers.getNumberArray("")).isEqualTo(new int[]{0});
        assertThat(numbers.getNumberArray(null)).isEqualTo(new int[]{0});
    }

    @Test
    @DisplayName("숫자 하나 입력 테스트")
    void oneInput_shouldBeSameInput() {
        assertThat(numbers.getNumberArray("1")).isEqualTo(new int[]{1});
    }

    @ParameterizedTest
    @DisplayName("Array 생성 테스트")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "//;\n1;2;3"})
    void createDefaultNumbers_shouldSplitToArray(String input) {
        assertThat(numbers.getNumberArray(input)).isEqualTo(new int[]{1,2,3});
    }

    @ParameterizedTest
    @DisplayName("중복문자열 Array 생성 테스트")
    @ValueSource(strings = {"1,1,3", "1:1:3", "1,1:3", "//;\n1;1;3"})
    void createDuplicatedNumbers_shouldSplitToArray(String input) {
        assertThat(numbers.getNumberArray(input)).isEqualTo(new int[]{1,1,3});
    }

    @ParameterizedTest
    @DisplayName("음수 또는 잘못된 입력 테스트")
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "//;1,2", "abc,1:2", "abc"})
    void invalidInput_shouldBeRuntimeException(String input) {
        assertThatThrownBy(() -> numbers.getNumberArray(input))
                .isInstanceOf(RuntimeException.class).hasMessage("Invalid input number.");
    }

}
