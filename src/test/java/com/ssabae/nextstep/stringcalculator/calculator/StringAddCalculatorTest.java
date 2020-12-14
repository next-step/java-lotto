package com.ssabae.nextstep.stringcalculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-15
 */
@SuppressWarnings("NonAsciiCharacters")
@DisplayName("String Add Calculator Test Class")
class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    @DisplayName("null_또는_빈문자 Test")
    public void splitAndSum_null_또는_빈문자() {
        int result = stringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자하나 Test")
    public void splitAndSum_숫자하나() {
        int result = stringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표구분자 Test")
    public void splitAndSum_쉼표구분자() {
        int result = stringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표_또는_콜론_구분자 Test")
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = stringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }


    @Test
    @DisplayName("음수 Test")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> stringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }


    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("custom_구분자 Test")
    @ValueSource(strings = {"//;\n1;2;3", "//;;;\n1;;;2;;;3", "//abc\n1abc2abc3"})
    void shouldBeTruePositiveValidatorTest(String value) {
        int result = stringAddCalculator.calculate(value);
        assertThat(result).isEqualTo(6);
    }

}
