package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputTest {
    @Test
    void 공백_여러개() {
        Input input = new Input(" 2  +  3  *  4  /  2 ");
        assertThat(input.split()).isEqualTo(new String[]{"2", "+", "3", "*", "4", "/", "2"});
    }

    @Test
    void 공백_기준_문자열_나누기() {
        Input input = new Input("2 + 3 * 4 / 2");
        assertThat(input.split()).isEqualTo(new String[]{"2", "+", "3", "*", "4", "/", "2"});
    }

    @Test
    void 양끝_공백() {
        assertThat(new Input("   2 + 3 * 4 / 2  ")).isEqualTo(new Input("2 + 3 * 4 / 2"));
    }

    @Test
    void null_또는_공백_문자_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Input(null));
        assertThatIllegalArgumentException().isThrownBy(() -> new Input(""));
        assertThatIllegalArgumentException().isThrownBy(() -> new Input(" "));
    }
}