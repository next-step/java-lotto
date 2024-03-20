package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringClassifierTest {

    @ParameterizedTest
    @ValueSource(strings = {"1","23","33","5"})
    @DisplayName("입력 받은 문자열이 숫자인지 판단한다.")
    void isNumber(String str) {
        //when & then
        assertThat(StringClassifier.isNumber(str)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"+","-","*","/"})
    @DisplayName("입력 받은 문자열이 사칙연산자인지 판단한다.")
    void isOperator(String str) {
        //when & then
        assertThat(StringClassifier.isOperator(str)).isTrue();
    }
}