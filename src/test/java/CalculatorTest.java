import model.Calculator;
import model.Extractor;
import model.Number;
import model.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("1+2/3 test")
    void test(){
        List<Number> numbers = List.of(new Number("1"), new Number("2"), new Number("3"));
        List<Operator> operators = List.of(Operator.PLUS, Operator.DIVISION);
        Calculator calculator = new Calculator(numbers, operators);

        int resultNumber = calculator.calculate();

        assertThat(resultNumber).isEqualTo(1);
    }


    @Test
    @DisplayName("1 test")
    void test2(){
        List<Number> numbers = List.of(new Number("1"));
        List<Operator> operators = new ArrayList<>();
        Calculator calculator = new Calculator(numbers, operators);

        int resultNumber = calculator.calculate();

        assertThat(resultNumber).isEqualTo(1);
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2  test")
    void test3(){
        List<Number> numbers = List.of(new Number("2"), new Number("3"), new Number("4"), new Number("2"));
        List<Operator> operators = List.of(Operator.PLUS, Operator.MULTIPLY, Operator.DIVISION);
        Calculator calculator = new Calculator(numbers, operators);

        int resultNumber = calculator.calculate();

        assertThat(resultNumber).isEqualTo(10);
    }

    @Test
    @DisplayName("숫자 갯수와 연산자 갯수 검증 실패 예외 테스트")
    void 예외_테스트(){
        List<Number> numbers = List.of(new Number("1"), new Number("3"));
        List<Operator> operators = List.of(Operator.PLUS,Operator.PLUS,Operator.PLUS,Operator.PLUS);

        assertThatIllegalArgumentException().isThrownBy(()->{
            new Calculator(numbers, operators);
        });
    }
}
