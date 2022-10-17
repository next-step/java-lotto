package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OperandTest {

    @Test
    public void 피연산자의_값을_반환한다() {
        Operand operand = new Operand(1);
        assertThat(operand.getValue()).isEqualTo(1);
    }
}
