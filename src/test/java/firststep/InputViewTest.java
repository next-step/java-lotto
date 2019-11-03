package firststep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    @DisplayName("커스텀 input array length")
    void inputTest() {
        assertThat(inputView.process("//;\n1;2;3").length).isEqualTo(3);
    }

    @Test
    @DisplayName("default input array length")
    void inputTest2() {
        assertThat(inputView.process("1,2").length).isEqualTo(2);
    }

    @Test
    @DisplayName("blank or null")
    void inputTest3() {
        assertThat(inputView.process("").length).isEqualTo(1);
    }

}