package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandsTest {
    @Test
    @DisplayName("팩토리 메소드를 테스트한다.")
    public void from() {
        List<Operand> operands = Stream.of("1", "2", "3")
                .map(Operand::from)
                .collect(Collectors.toList());
        Operands expected = new Operands(operands);

        assertThat(Operands.from("1,2,3", ","))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Operands 의 덧셈을 테스트한다.")
    public void sum() {
        Operand actual = Operands.from("1,2,3", ",").sum();
        assertThat(actual).isEqualTo(Operand.from("6"));
    }
}
