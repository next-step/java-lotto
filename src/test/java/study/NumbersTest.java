package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumbersTest {
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @DisplayName("Numbers 생성자 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1,-2,3", "1:2:-3", "1,2:aa"})
    void numbersConstructor(String input) {
        assertThatThrownBy(() -> {
            new Numbers(stringAddCalculator.splitInput(input));
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수 또는 정수 이외의 값은 더할수없습니다.");
    }

    @DisplayName("getNumbers 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3","//#\n1#2#3"})
    void getNumbers(String input) {
        Numbers numbers = new Numbers(stringAddCalculator.splitInput(input));
        assertThat(numbers.getNumbers()).containsExactly(1,2,3);
    }
}