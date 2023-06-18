package edu.nextstep.camp.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class IntNumberTest {

    private IntNumber number;

    @BeforeEach
    void init() {
        number = new IntNumber("30");
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"+:2:32", "-:9:21", "*:3:90", "/:4:7"})
    void 연산_문자에_따른_연산(String symbol, String calculateNumber, int expected) {
        int result = number.calculateBaseSymbol(symbol, calculateNumber);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 기호_공백_NULL_에러_테스트(String symbol) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> number.calculateBaseSymbol(symbol, "5")
        ).withMessageContaining("symbol is blank or null");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 숫자_공백_NULL_에러_테스트(String numberStr) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> number.calculateBaseSymbol("+", numberStr)
        ).withMessageContaining("number is blank or null");
    }

    @Test
    void 숫자_유효성_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> number.calculateBaseSymbol("+", "#$%")
        ).withMessageContaining("For input string: \"#$%\"");
    }

    @Test
    void 기호_유효성_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> number.calculateBaseSymbol("@", "5")
        ).withMessageContaining("not support symbol");
    }


}
