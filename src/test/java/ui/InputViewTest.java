package ui;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputViewTest {
    @Test
    void 정상_입력_테스트() {
        String input1 = "2 + 3 * 4 / 2";
        String input2 = "7 / 3 - 4";

        assertAll(
                () -> assertThat(InputView.convertStringToArray(input1)).containsExactly("2", "+", "3", "*", "4", "/", "2"),
                () -> assertThat(InputView.convertStringToArray(input2)).containsExactly("7", "/", "3", "-", "4")
        );
    }
}