package step1;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;
import static step1.Operator.*;

public class ExpressionTest {

    @Test
    void 피연산자가_없는_수식은_에러_반환() {
        Queue<Operand> operands = new LinkedList<>();
        Queue<Operator> operators = new LinkedList<>(List.of(PLUS));

        assertThatThrownBy(() -> new Expression(operands, operators))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 수식은_연산자와_피연산자를_담고_식의_결과를_만들어낸다() {
        Queue<Operand> operands = new LinkedList<>(List.of(
                new Operand(2),
                new Operand(3),
                new Operand(4),
                new Operand(2)
        ));
        Queue<Operator> operators = new LinkedList<>(List.of(
                PLUS,
                MULTIPLY,
                DIVIDE
        ));

        Expression expression = new Expression(operands, operators);
        assertThat(expression.evaluate()).isEqualTo(10);
    }


    @Test
    void 연산이_끝났는데_피연산자가_남아있다면_에러() {
        Queue<Operand> operands = new LinkedList<>(List.of(
                new Operand(2),
                new Operand(3),
                new Operand(4)
        ));
        Queue<Operator> operators = new LinkedList<>(List.of(
                PLUS
        ));

        assertThatThrownBy(() -> new Expression(operands, operators))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 연산이_끝났는데_연산자가_남아있다면_에러() {
        Queue<Operand> operands = new LinkedList<>(List.of(
                new Operand(2)
        ));
        Queue<Operator> operators = new LinkedList<>(List.of(
                PLUS,
                MULTIPLY,
                DIVIDE
        ));

        assertThatThrownBy(() -> new Expression(operands, operators))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 수식은_여러번_평가해도_항상_같은_결과를_반환한다() {
        Queue<Operand> operands = new LinkedList<>(List.of(
                new Operand(2),
                new Operand(3),
                new Operand(4),
                new Operand(2)
        ));
        Queue<Operator> operators = new LinkedList<>(List.of(
                PLUS,
                MULTIPLY,
                DIVIDE
        ));

        Expression expression = new Expression(operands, operators);
        assertThat(expression.evaluate()).isEqualTo(10);
        assertThat(expression.evaluate()).isEqualTo(10);
        assertThat(expression.evaluate()).isEqualTo(10);
    }
}