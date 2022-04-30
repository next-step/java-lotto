package step1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "입력 값 테스트")
class InputTest {

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @NullAndEmptySource
    void 입력_값이_널이거나_공백이면_예외(String text) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Input(text)
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @ValueSource(strings = {"1+1-1", "- 1 - 1 - 1", "1 - 1 + 1 +", "가 + 나 + 다"})
    void 입력_값이_패턴에_맞지_않으면_예외(String text) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Input(text)
        );
    }

    @Test
    void 입력_값이_패턴에_맞으면_공백을_기준으로_분리된_값을_갖는_객체를_생성() {
        String text = "1 + 1 - 1";

        Input input1 = new Input(text);
        Input input2 = new Input(text);

        assertThat(input1).isEqualTo(input2);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} => {1}")
    @CsvSource(value = {"1 + 1:1", "1 + 1 + 1:2", "1 + 1 + 1 + 1:3"}, delimiter = ':')
    void 문자열_수식에서_연산해야하는_횟수를_반환(String text, int count) {
        Input input = new Input(text);
        assertThat(input.getOperationBundleCount()).isEqualTo(count);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} => {1}")
    @CsvSource(value = {"1 + 1:1", "2 + 1:2", "3 + 1:3"}, delimiter = ':')
    void 문자열_수식에서_첫번째_숫자를_반환(String text, int count) {
        Input input = new Input(text);
        assertThat(input.getFirstOperand()).isEqualTo(count);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} => {1}")
    @CsvSource(value = {"1 + 1:ADD", "1 - 1:SUBTRACT", "1 * 1:MULTIPLY", "1 / 1:DIVIDE"}, delimiter = ':')
    void 문자열_수식의_다음_연산자를_반환(String text, Operator operator) {
        Input input = new Input(text, new Index(1));
        assertThat(input.getNextOperator()).isEqualTo(operator);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} => {1}")
    @CsvSource(value = {"1 + 1:1", "1 + 2:2", "1 - 3:3"}, delimiter = ':')
    void 문자열_수식의_다음_연산자를_반환(String text, int operand) {
        Input input = new Input(text, new Index(2));
        assertThat(input.getNextOperand()).isEqualTo(operand);
    }

}