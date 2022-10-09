package view;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈값이 입력되었을 때 에러를 반환하는지 확인")
    void validateNullAndEmptyTest(String inputs) {

        String[] stringInputs = inputs.split(" ");

        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                inputValidation.validationInputValues(stringInputs);
                System.out.println(stringInputs.length);
            }).withMessageMatching("빈 값이 입력되었습니다. 값을 입력하세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "d"})
    @DisplayName("숫자가 아닌 값을 입력했을 때 에러를 반환하는지 확인")
    void validateNumberTest(String inputs) {

        String[] stringInputs = inputs.split(" ");

        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                inputValidation.validationInputValues(stringInputs);
                System.out.println(stringInputs.length);
            }).withMessageMatching("숫자와 사칙기호만 입력하세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"&", "%", "^"})
    @DisplayName("사칙기호가 아닌 값을 입력했을 때 에러를 반환하는지 확인")
    void validateSymbolTest(String inputs) {

        String[] stringInputs = inputs.split(" ");

        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                inputValidation.validationInputValues(stringInputs);
                System.out.println(stringInputs.length);
            }).withMessageMatching("숫자와 사칙기호만 입력하세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"/ 6", "* 7", "- 8", "+ 9"})
    @DisplayName("첫번째값이 숫자가 아닌 값을 입력했을 때 에러를 반환하는지 확인")
    void validateFirstInputValue(String inputs) {

        String[] stringInputs = inputs.split(" ");

        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                inputValidation.validationInputValues(stringInputs);
                System.out.println(stringInputs.length);
            }).withMessageMatching("첫번째값은 무조건 숫자가 입력되어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"6 /", "7 *", "8 -", "9 +"})
    @DisplayName("마지막값이 숫자가 아닌 값을 입력했을 때 에러를 반환하는지 확인")
    void validateLastInputValue(String inputs) {

        String[] stringInputs = inputs.split(" ");

        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                inputValidation.validationInputValues(stringInputs);
                System.out.println(stringInputs.length);
            }).withMessageMatching("마지막값은 무조건 숫자가 입력되어야 합니다.");
    }

}