package stringcalculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import stringcalculator.model.Input;
import stringcalculator.model.Operand;
import stringcalculator.model.Operator;

import java.util.List;

import static stringcalculator.model.Operator.*;

public class ParserTest {
    @Test
    void 피연산자를_파싱한다() {
        Input input = new Input("2 + 3 * 4 / 2");
        List<Operand> actual = Parser.operands(input.value());
        List<Operand> expected = List.of(new Operand(2), new Operand(3), new Operand(4), new Operand(2));
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 연산자를_파싱한다() {
        Input input = new Input("2 + 3 * 4 / 2");
        List<Operator> actual = Parser.operators(input.value());
        List<Operator> expected = List.of(SUM, MULTIPLY, DIVIDE);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
