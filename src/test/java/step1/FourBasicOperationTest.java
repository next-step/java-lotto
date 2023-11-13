package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.model.FourBasicOperation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FourBasicOperationTest {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3"})
    @DisplayName("덧셈 연산자를 테스트한다. 2 + 3을 넣을경우 5가 출력된다.")
    void plusTest(String formula) {
        int result = new FourBasicOperation(formula).run();
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7 - 3"})
    @DisplayName("뺄셈 연산자를 테스트한다. 7 - 3을 넣을경우 4가 출력된다.")
    void takeOutTest(String formula) {
        int result = new FourBasicOperation(formula).run();
        assertThat(result).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7 * 3"})
    @DisplayName("곱셈 연산자를 테스트한다. 7 * 3을 넣을경우 21이 출력된다.")
    void multiplyTest(String formula) {
        int result = new FourBasicOperation(formula).run();
        assertThat(result).isEqualTo(21);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 / 2"})
    @DisplayName("뺄셈 연산자를 테스트한다. 4 / 2를 넣을경우 2가 출력된다.")
    void divisionTest(String formula) {
        int result = new FourBasicOperation(formula).run();
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("수학의 우선순위를 무시하고 순서대로 연산을 수행한다.")
    void formulaTest(String formula) {
        int result = new FourBasicOperation(formula).run();
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 / 2 $ 3"})
    @DisplayName("사칙연산 기호가 아닐 경우 예외가 발생한다.")
    void invalidFormulaTest(String formula) {
        assertThatThrownBy(() -> new FourBasicOperation(formula).run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }
}
