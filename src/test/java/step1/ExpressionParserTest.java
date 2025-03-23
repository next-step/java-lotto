package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static step1.Operator.*;

public class ExpressionParserTest {

    @Test
    void ExpressionFactory는_문자열을_받아서_수식을_반환한다() {
        String input = "2 + 3";
        Expression expression = ExpressionParser.parse(input);

        Queue<Operand> operands = new LinkedList<>(List.of(
                new Operand(2),
                new Operand(3)
        ));
        Queue<Operator> operators = new LinkedList<>(List.of(
                PLUS
        ));

        assertThat(expression).isEqualTo(new Expression(operands, operators));
    }
}
