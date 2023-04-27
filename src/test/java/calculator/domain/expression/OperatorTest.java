package calculator.domain.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("연산자 테스트")
class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"@", "&", "^", "$", "_", "!"})
    void 정의된_연산자가_아닌_문자는_예외를_발생한다(String operator) {
        assertThatThrownBy(() -> Operator.of(operator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:true", "-:true", "/:true", "*:true", "@:false", "&:false"}, delimiter = ':')
    void 지정된_연산자에_해당하는지_확인할수있다(String operator, Boolean expected) {
        boolean isValidOperator = Operator.isOperator(operator);

        assertThat(isValidOperator).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 연산자_객체에_선언한_연산자기호를_꺼낼수_있다(String input) {
        Operator operator = Operator.of(input);
        assertThat(operator.symbol()).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource({
            "ADDITION, +",
            "SUBTRACTION, -",
            "MULTIPLICATION, *",
            "DIVISION, /"
    })
    void 연산자_객체에_이미_선언되어있는_상수_기호를_꺼낼수있다(Operator operator, String expectedSymbol) {
        assertThat(operator.symbol()).isEqualTo(expectedSymbol);
    }



}