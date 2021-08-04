package lotto.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
//    @Test
//    @DisplayName("빈 문자열 이나 null 을 입력했을 때 boolean 값 확인")
//    void checkEmptyAndNull(){
//        Calculator calculator = new Calculator(null);
//        assertThat(calculator.checkEmptyAndNull()).isTrue();
//    }
//
//    @Test
//    @DisplayName("문자열로 숫자 하나를 입력 했는지 검증 하는 테스트")
//    void onlyNumberTest() {
//        Calculator calculator = new Calculator("3");
//        assertThat(calculator.checkOnlyNumber()).isTrue();
//    }
//    @Test
//    @DisplayName("문자열로 숫자 하나를 입력 했는지 검증 하는 테스트2")
//    void onlyNumberTest2() {
//        Calculator calculator = new Calculator("s");
//        assertThat(calculator.checkOnlyNumber()).isFalse();
//    }

    @Test
    @DisplayName("음수를 포함했을 때 예외처리 하는 테스트")
    void isNegativeNumber() {
        Calculator calculator = new Calculator("-1,2,4");
        assertThatThrownBy(() -> calculator.isNegativeNumber("-1")).isInstanceOf(RuntimeException.class);
    }

//    @Test
//    @DisplayName("문자열에 커스텀 구분자가 있는지 확인하는 테스트")
//    void checkCustomDelimiter() {
//        Calculator calculator = new Calculator("//;\n1;2;3");
//        assertThat(calculator.checkCustomDelimiter()).isTrue();
//    }
//
//    @Test
//    @DisplayName("문자열에 커스텀 구분자가 있는지 확인하는 테스트2")
//    void checkCustomDelimiter2() {
//        Calculator calculator = new Calculator("//.\n3.4.2");
//        assertThat(calculator.checkCustomDelimiter()).isTrue();
//    }

    @Test
    @DisplayName("빈 문자열이나 null 일 때 0 반환하는 테스트")
    void calculator_null() {
        String text = " ";
        Calculator calculator = new Calculator(text);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환하는 테스트 ")
    void calculator_onlyNumber() {
        String text = "2";
        Calculator calculator = new Calculator(text);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("컴마(,)로 구분된 숫자들의 합을 반환하는 테스트")
    void calculator_commaDelimiter() {
        String text = "2,5";
        Calculator calculator = new Calculator(text);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("컴마(,) 콜론(:) 으로 구분된 숫자들의 합을 반환하는 테스트")
    void calculator_commaAndColonDelimiter() {
        String text = "2,5:14";
        Calculator calculator = new Calculator(text);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 반환하는 테스트")
    void calculator_customDelimiter() {
        String text = "//;\n1;2;3";
        Calculator calculator = new Calculator(text);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 반환하는 테스트 2")
    void calculator_customDelimiter2() {
        String text = "//;\n1;2,3:4;2";
        Calculator calculator = new Calculator(text);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 반환하는 테스트 3")
    void calculator_customDelimiter3() {
        String text = "//,\n3,4,2";
        Calculator calculator = new Calculator(text);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합을 반환하는 테스트 4")
    void calculator_customDelimiter4() {
        String text = "///\n3/4/2";
        Calculator calculator = new Calculator(text);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(9);
    }
}