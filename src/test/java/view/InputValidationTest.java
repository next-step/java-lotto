package view;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import exception.NullAndEmptyException;

class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("빈값이 입력되었을 때 에러를 반환하는지 확인")
    void validateNullAndEmptyTest(String inputs) {

        assertThatExceptionOfType(NullAndEmptyException.class)
            .isThrownBy(() -> {
                inputValidation.validateNullAndEmpty(inputs);
            }).withMessageMatching("빈 값이 입력되었습니다. 값을 입력하세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "d"})
    @DisplayName("숫자가 아닌 값을 입력했을 때 에러를 반환하는지 확인")
    void validateNumberTest(String inputs) {

        assertThatExceptionOfType(NullAndEmptyException.class)
            .isThrownBy(() -> {
                inputValidation.validateNullAndEmpty(inputs);
            }).withMessageMatching("잘못된 문자열이 입력되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"&", "%", "^"})
    @DisplayName("사칙기호가 아닌 값을 입력했을 때 에러를 반환하는지 확인")
    void validateSymbolTest(String inputs) {

        assertThatExceptionOfType(NullAndEmptyException.class)
            .isThrownBy(() -> {
                inputValidation.validateNullAndEmpty(inputs);
            }).withMessageMatching("잘못된 문자열이 입력되었습니다.");
    }

}