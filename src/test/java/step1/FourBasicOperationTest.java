package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.model.FourBasicOperation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FourBasicOperationTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3=5", "7 - 3=4", "7 * 3=21", "4 / 2=2", "2 + 3 * 4 / 2=10"}, delimiter = '=')
    @DisplayName("두개의 숫자 기준으로 사칙연산 결과 값을 테스트한다.")
    void basicTest(String formula, int expected) {
        int result = new FourBasicOperation(formula).run();
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 4 / 2=3", "7 - 3 * 3=12", "2 + 3 * 4 / 2=10", "4 / 2 + 3 - 1 * 0=0", "4 - 2 + 4 / 2 * 3=9"}, delimiter = '=')
    @DisplayName("사칙연산을 테스트한다. 수학의 사칙연산 규칙은 무시하고 순서대로 연산을 수행한다.")
    void complicateTest(String formula, int expected) {
        int result = new FourBasicOperation(formula).run();
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 / 2 $ 3", "3 % 2 #", "8 & 0 ( 2", "1 + 2 @ 3", "9 ! 4 ; 2"})
    @DisplayName("사칙연산 기호가 아닐 경우 예외가 발생한다.")
    void invalidFormulaTest(String formula) {
        assertThatThrownBy(() -> new FourBasicOperation(formula).run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }
}
