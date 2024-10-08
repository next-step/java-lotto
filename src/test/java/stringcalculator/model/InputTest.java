package stringcalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringcalculator.model.Input.NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER;

public class InputTest {
    @Test
    void 입력문자열을_잘라_저장한다() {
        String input = "2 + 3 * 4 / 2";
        Input actual = new Input(input);
        Input expected = Input.of(new String[]{"2", "+", "3", "*", "4", "/", "2"});
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 입력문자열_size_는_홀수가_아니면_예외처리한다() {
        assertThatThrownBy(() -> {
            String input = "2 + 3 * 4 / ";
            new Input(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER);
    }


    @Test
    void 입력문자열을_메모리목록으로_치환한다() {
        String inputString = "2 + 3 * 4 / 2";
        Input input = new Input(inputString);
        Memories actual = input.convertToMemories();
        Memories expected = new Memories(new Operand("2"),
                new Memory(Operator.convertToOperator("+"), new Operand("3")),
                new Memory(Operator.convertToOperator("*"), new Operand("4")),
                new Memory(Operator.convertToOperator("/"), new Operand("2"))
        );

        assertThat(actual).isEqualTo(expected);
    }
}
