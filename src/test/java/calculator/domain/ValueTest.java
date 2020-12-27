package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValueTest {

    private Value value;

    @BeforeEach
    void setUp() {
        value = new Value();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈값 및 null 입력 시 return 0")
    void validateNullAndEmpty(String inputValue) {
        assertThat(value.validateNullAndEmpty(inputValue)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"value", "-1", "*", "%"})
    @DisplayName("양의정수 이외의 값 입력 시")
    void exceptionInputValue(String inputValue) {
        assertThrows(RuntimeException.class, () -> {
           value.validatePositiveValue(inputValue);
        });
    }
}
