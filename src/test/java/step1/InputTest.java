package step1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "입력 값 테스트")
class InputTest {

    @Test
    void 입력_값을_Wrapping_하는_객체를_생성() {
        String text = "가나다라마바사";

        Input input1 = new Input(text);
        Input input2 = new Input(text);

        assertThat(input1).isEqualTo(input2);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @NullAndEmptySource
    void 입력_값이_널이거나_공백이면_예외(String text) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Input(text)
        );
    }

    @Test
    void 공백을_기준으로_주어진_문자열을_분리() {
        Input input = new Input("1 2 3 4");

        String[] result = input.split();

        assertThat(result).containsExactly("1", "2", "3", "4");
    }


}