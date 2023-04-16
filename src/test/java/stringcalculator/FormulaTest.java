package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.Formula.SplitFormula;

public class FormulaTest {

    @Test
    void 계산() {
        Formula formula = new Formula("1 + 2");
        SplitFormula.split(formula);
        formula.calculate();
        assertThat(formula.result()).isEqualTo(new Number("3"));
    }

    @Test
    void 연산_숫자_연산_분리() {
        Formula formula = new Formula("- 1 + 2 /");
        SplitFormula.split(formula);
        assertAll(
            () -> assertThat(formula.numbers()).containsExactly(new Number("0"), new Number("1"),
                new Number("2"), new Number("0")),
            () -> assertThat(formula.operations()).containsExactly(new Operator("-"),
                new Operator("+"), new Operator("/"))
        );
    }

    @Test
    void 연산_숫자_분리() {
        Formula formula = new Formula("- 1 + 2");
        SplitFormula.split(formula);
        assertAll(
            () -> assertThat(formula.numbers()).containsExactly(new Number("0"), new Number("1"),
                new Number("2")),
            () -> assertThat(formula.operations()).containsExactly(new Operator("-"),
                new Operator("+"))
        );
    }

    @Test
    void 숫자_연산_분리() {
        Formula formula = new Formula("1 + 2");
        SplitFormula.split(formula);
        assertAll(
            () -> assertThat(formula.numbers()).containsExactly(new Number("1"), new Number("2")),
            () -> assertThat(formula.operations()).containsExactly(new Operator("+"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈문자열_입력(String input) {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Formula(input))
            .withMessageMatching("빈 수식은 입력할 수 없습니다.");
    }

    @Test
    void 널_입력() {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Formula(null))
            .withMessageMatching("빈 수식은 입력할 수 없습니다.");
    }

    @Test
    void 수식입력() {
        assertThat(new Formula("1+2")).isEqualTo(new Formula("1+2"));
    }

}
