package calculator;

import calculator.validation.InputValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    public void setUp() {
        inputValidation = new InputValidation();
    }

    @DisplayName("입력값 검증 테스트")
    @Test
    public void inputValidation() {
        //given
        List<String> input = List.of("2", "+", "3", "*", "4", "/", "2");
        //when
        boolean result = inputValidation.validation(input);
        //then
        assertThat(result).isTrue();
    }

    @Nested
    @DisplayName("예외처리 테스트")
    class ValidationFaild {
        @DisplayName("숫자 외 값이 처음 입력되었을 때 예외처리 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"a", "-"})
        public void 처음_입력값_숫자가_아닌_경우(String value) {
            //given
            List<String> input = List.of(value, "+", "3", "*", "4", "/", "2");
            //when
            //then
            assertThatThrownBy(() -> inputValidation.validation(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자가 아닌 값이 입력되었을 때 예외처리 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"a", "-"})
        public void 마지막_입력값_숫자가_아닌_경우(String value) {
            //given
            List<String> input = List.of("2", "+", "3", "*", "4", "/", value);
            //when
            //then
            assertThatThrownBy(() -> inputValidation.validation(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("연산자가 연속으로 입력되었을 때 예외처리 테스트")
        @Test
        public void 연산자가_연속으로_입력된_경우() {
            //given
            List<String> input = List.of("2", "++", "3", "*", "4", "/", "2");
            //when
            //then
            assertThatThrownBy(() -> inputValidation.validation(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("null, 빈값이 입력되었을 때 예외처리 테스트")
        @ParameterizedTest
        @NullAndEmptySource
        public void null_빈값이_입력된_경우(List<String> input) {
            //given
            //when
            //then
            assertThatThrownBy(() -> inputValidation.validation(input)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
