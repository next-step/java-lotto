package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordTest {
    private static final String CUSTOM_EXPRESSION = "//;/n11;2;3";
    private static final String GENERAL_EXPRESSION = "1,2";
    private Word word;

    @BeforeEach
    void setUp() {
        word = new Word();
    }

    @DisplayName("입력한 값을 반환한다.")
    @Test
    void makeNumbersInGeneralExpressionTest() {
        String expression = GENERAL_EXPRESSION;
        List<Integer> numbers = word.makeNumbers(expression);
        assertThat(numbers.get(0)).isEqualTo(1);
        assertThat(numbers.get(1)).isEqualTo(2);
    }

    @DisplayName("구분자를 기준으로 분리한 모든 정수값을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2"})
    void makeNumbersInTwoGeneralExpressionTest(String input) {
        List<Integer> numbers = word.makeNumbers(input);
        assertThat(numbers.get(0)).isEqualTo(1);
        assertThat(numbers.get(1)).isEqualTo(2);
    }

    @DisplayName("커스텀 구분자를 기준으로 분리한 모든 정수값을 반환한다. ")
    @Test
    void makeNumbersInCustomExpressionTest() {
        List<Integer> numbers = word.makeNumbers(CUSTOM_EXPRESSION);
        assertThat(numbers.get(0)).isEqualTo(11);
        assertThat(numbers.get(1)).isEqualTo(2);
        assertThat(numbers.get(2)).isEqualTo(3);
    }

    @DisplayName("입력된 문자의 시작값이 숫자인지 '/' 인지 판별한다.")
    @Test
    void isCustomInputTest() {
        Boolean isCustom = word.isCustomInput(CUSTOM_EXPRESSION);
        Boolean isGeneral = word.isCustomInput(GENERAL_EXPRESSION);

        assertThat(isCustom).isTrue();
        assertThat(isGeneral).isFalse();
    }

    @DisplayName("커스텀 구분자가 입력된 경우 커스텀 구분자를 찾을 수 있다.")
    @Test
    void findCustomSeparatorTest() {
        String customSeparator = word.findCustomSeparator(CUSTOM_EXPRESSION);
        assertThat(customSeparator).isEqualTo(";");
    }

    @DisplayName("입력값이 음수인 경우 `RuntimeException` throw 한다.")
    @Test
    void validationTest() {
        String expression = "-1,2,3";

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            word.notNegativeValidation(word.makeNumbers(expression));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    void emptyOrNullTest(final String text) {
        assertThrows(IllegalArgumentException.class, () -> word.isEmptyOrNull(text));
    }
}
