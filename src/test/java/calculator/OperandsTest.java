package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandsTest {
    private List<Operand> input;

    @BeforeEach
    void setUp() {
        input = Arrays.asList(Operand.of(1),
                Operand.of(2),
                Operand.of(3));
    }

    @Test
    @DisplayName("Operands를 생성할 수 있다.")
    void create_Operands() {
        Operands operands = new Operands(input);
        assertThat(operands).isInstanceOf(Operands.class);
    }

    @Test
    @DisplayName("Operands는 합계 연산을 할 수 있다.")
    void add_Operands() {
        Operands operands = new Operands(input);
        assertThat(operands.sum()).isEqualTo(Operand.of(1 + 2 + 3));
    }
}
