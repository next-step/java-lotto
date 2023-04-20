package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    @DisplayName("사용자로부터 콘솔에 입력을 받아 해당 값을 반환한다.")
    void test01() {
        String expected = "2 + 3 * 4";
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        String actual = InputView.console();
        assertThat(actual).isEqualTo(expected);
    }
    
}