package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OperandsTest {

    @Test
    public void 가장_첫번째_순서의_피연산자를_반환한다() {
        Operands operands = Operands.of(List.of("1", "2", "3"));
        assertThat(operands.poll().getValue()).isEqualTo(1);
    }
}
