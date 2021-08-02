package lotto.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    @DisplayName("문자열로 숫자 하나를 입력 했는지 검증 하는 테스트")
    void onlyNumberTest() {
        Calculator calculator = new Calculator("3");
        Assertions.assertThat(calculator.checkOnlyNumber()).isTrue();
    }

    @Test
    @DisplayName("음수를 포함했을 때 예외처리 하는 테스트")
    void isNegativeNumber() {
        Calculator calculator = new Calculator("-1,2,4");
        Assertions.assertThatThrownBy(() -> calculator.isNegativeNumber("-1")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("문자열에 커스텀 구분자가 있는지 확인하는 테스트")
    void checkCustomDelimiter() {
        Calculator calculator = new Calculator("//;\n1;2;3");
        assertThat(calculator.checkCustomDelimiter()).isTrue();
    }

}