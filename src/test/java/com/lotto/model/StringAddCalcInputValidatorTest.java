package com.lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalcInputValidatorTest {

    private StringAddCalcInputValidator stringAddCalcInputValidator;

    @BeforeEach
    void setUp() {
        stringAddCalcInputValidator = new StringAddCalcInputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "A", "-3"})
    @DisplayName("숫자 이외의 값 또는 음수 입력 시 예외처리 테스트")
    void invalidValueTest(String invalidValue) {
        assertThatThrownBy(() -> stringAddCalcInputValidator.validateStringNumber(invalidValue)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null 값을 입력 할 경우")
    void isNullTest(String nullValue) {
        assertThat(stringAddCalcInputValidator.validateNullAndEmpty(nullValue)).isEqualTo("0");
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("빈 값을 입력 할 경우")
    void isEmpty(String emptyValue) {
        assertThat(stringAddCalcInputValidator.validateNullAndEmpty(emptyValue)).isEqualTo("0");
    }
}
