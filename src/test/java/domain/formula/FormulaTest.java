package domain.formula;

import static domain.formula.Formula.FORMULA_VALIDATION_FAILED;
import static domain.formula.Formula.getFormulaByInput;
import static domain.formula.Numbers.NUMBER_FORMAT_EXCEPTION;
import static domain.formula.Numbers.getNumbersByFormula;
import static domain.formula.Operators.getOperatorsByFormula;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FormulaTest {

    @Test
    @DisplayName("수식의 입력값이 옳지 않은 경우 오류 발생(수, 문자, 수)")
    void validationCheck() {
        List<String> formulaList = List.of(new String[]{"4", "+", "2", "-"});
        assertThatThrownBy(() -> getFormulaByInput(formulaList))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(FORMULA_VALIDATION_FAILED);
    }

    @Test
    @DisplayName("잘못된 수식을 입력하면 오류발생")
    void validationCheck2() {
        List<String> formulaList = List.of(new String[]{"+", "4", "-"});
        assertThatThrownBy(() -> getFormulaByInput(formulaList))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_FORMAT_EXCEPTION);
    }


    @Test
    @DisplayName("정확한 값이 입력되면 Formula 객체가 생성된다.")
    void makeNumbers() {
        List<String> plainFormula = List.of(new String[]{"1", "+", "2", "+", "3"});

        Formula formulaByInput = new Formula(getNumbersByFormula(plainFormula),
                getOperatorsByFormula(plainFormula));

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        Numbers numbers = new Numbers(integerList);
        List<String> stringList = Arrays.asList("+", "+");
        Operators operators = new Operators(stringList);

        Formula expected = new Formula(numbers, operators);

        assertThat(formulaByInput).isEqualTo(expected);
    }
}
