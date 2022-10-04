package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import calculator.exception.EmptyFormulaException;
import calculator.exception.InvalidFormulaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FormulaElementsTest {

    private static final String INIT_OPERATOR = "+";

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "15 + 17 * 20 - 1"})
    @DisplayName("수식 구성요소 큐에는 언제나 첫번째 요소로 초기 연산자가 추가되어 있다.")
    void get_formula_element(String formula) {
        String expected = INIT_OPERATOR + formula.replace(" ", "");
        FormulaElements formulaElements = new FormulaElements(formula);

        String result = "";
        while (!formulaElements.isEmpty()) {
            result = result.concat(formulaElements.poll());
        }

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("수식 구성요소 큐 생성 시 빈 문자열을 제공하면 예외 발생.")
    void fail_to_init_by_empty_formula() {
        assertThatExceptionOfType(EmptyFormulaException.class)
                .isThrownBy(() -> new FormulaElements(" "));
    }

    @Test
    @DisplayName("수식 구성요소가 남아있지 않은데 요소 획득 시도 시 예외 발생.")
    void fail_to_get_from_empty_deque() {
        FormulaElements formulaElements = getEmptyFormulaElements();
        assertThatExceptionOfType(InvalidFormulaException.class)
                .isThrownBy(formulaElements::poll);
    }

    private FormulaElements getEmptyFormulaElements() {
        FormulaElements formulaElements = new FormulaElements("2");
        formulaElements.poll();
        formulaElements.poll();
        return formulaElements;
    }

}
