package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitterTest {

    private final Splitter splitter = new Splitter();

    private final Operand one = new Operand("1");
    private final Operand two = new Operand("2");
    private final Operand three = new Operand("3");
    private final Operand four = new Operand("4");

    private final Operands oneTwo = new Operands(Arrays.asList(one, two));
    private final Operands oneTwoThree = new Operands(Arrays.asList(one, two, three));
    private final Operands oneTwoThreeFour = new Operands(Arrays.asList(one, two, three, four));

    @Test
    void split() {
        assertThatThrownBy(() -> {
            splitter.split("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("피연산자는 0 이상의 양수여야합니다.");
        assertThatThrownBy(() -> {
            splitter.split(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("text는 null일 수 없습니다.");
        assertThat(splitter.split("1,2")).isEqualTo(oneTwo);
        assertThat(splitter.split("1,2,3")).isEqualTo(oneTwoThree);
        assertThat(splitter.split("1,2:3")).isEqualTo(oneTwoThree);
        assertThat(splitter.split("//;\n1;2;3")).isEqualTo(oneTwoThree);
        assertThat(splitter.split("//;\n1,2:3;4")).isEqualTo(oneTwoThreeFour);
        assertThat(splitter.split("//-\n1-2")).isEqualTo(oneTwo);
    }

}
