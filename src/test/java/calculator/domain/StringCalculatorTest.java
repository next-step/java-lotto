package calculator.domain;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;
    @BeforeEach
    void setup(){
        List<String> input = Arrays.asList("1");
        stringCalculator = new StringCalculator(input);
    }
    @Test
    @DisplayName("사칙연산자 연산자 오류 확인")
    void validate_연산자오류확인(){
        assertThatThrownBy(() -> stringCalculator.validate("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @DisplayName("사칙연산자 연산자 validate 확인")
    @ValueSource(strings={"+","-","*","/"})
    void validate_연산자확인(String input){
        assertThat(stringCalculator.validate(input)).containsAnyOf("+","-","*","/");
    }
}
