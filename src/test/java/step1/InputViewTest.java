package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class InputViewTest {

    @Test
    void split_테스트() {
        String input = "1 + 2 * 3";
        InputView inputView = new InputView();
        assertThat(inputView.splitInput(input)).containsExactly("1", "+", "2", "*", "3");
    }

    @Test
    void 공백_검증() {
        InputView inputView = new InputView();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.emptyValidate("");
        });
    }

    @Test
    void 연산자_검증() {
        InputView inputView = new InputView();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.operatorValidate("$");
        });
    }
}
