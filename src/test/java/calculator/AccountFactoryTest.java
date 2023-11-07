package calculator;

import calculator.factory.AccountFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountFactoryTest {

    @DisplayName("더하기 계산기 테스트")
    @Test
    void 더하기_테스트() {
        // given
        int firstNumber = 1;
        int secondNumber = 2;
        String operator = "+";
        // when
        int result = AccountFactory.getAccountInstance(operator).calculate(firstNumber, secondNumber);
        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("빼기 계산기 테스트")
    @Test
    void 빼기_테스트() {
        // given
        int firstNumber = 3;
        int secondNumber = 2;
        String operator = "-";
        // when
        int result = AccountFactory.getAccountInstance(operator).calculate(firstNumber, secondNumber);
        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("곱하기 계산기 테스트")
    @Test
    void 곱하기_테스트() {
        // given
        int firstNumber = 3;
        int secondNumber = 2;
        String operator = "*";
        // when
        int result = AccountFactory.getAccountInstance(operator).calculate(firstNumber, secondNumber);
        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("나누기 계산기 테스트")
    @Test
    void 나누기_테스트() {
        // given
        int firstNumber = 7;
        int secondNumber = 3;
        String operator = "/";
        // when
        int result = AccountFactory.getAccountInstance(operator).calculate(firstNumber, secondNumber);
        // then
        assertThat(result).isEqualTo(2);
    }
}
