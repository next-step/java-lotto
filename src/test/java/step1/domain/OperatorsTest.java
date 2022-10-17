package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OperatorsTest {

    @Test
    public void 가장_첫번째_순서의_연산자를_반환한다() {
        Operators operators = Operators.of(List.of("+", "*", "/"));
        assertThat(operators.poll()).isInstanceOf(AdditionOperator.class);
    }
}
