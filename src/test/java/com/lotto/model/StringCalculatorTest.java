package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {";0", "1,2;3", "1,2,3;6", "1,2:3;6"}, delimiter = ';')
    @DisplayName("쉽표 또는 콜론 구분자를 기준으로 분리한 각 숫자의 합")
    void addTest(String inputValue, int result) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.execute(inputValue)).isEqualTo(result);
    }

    @Test
    @DisplayName("커스텀 구분자를 기준으로 분리한 각 숫자의 합")
    void addByCustomDelimiter() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.execute("//;\n2;5;8")).isEqualTo(15);
    }
}
