package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import me.namuhuchutong.lotto.ui.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    
    private static final String NEW_LINE = "\n";

    @BeforeEach
    void setUp() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
    }

    private void setIn(String givenInput) {
        String input = createInputString(givenInput);
        System.setIn(convertForInputStream(input));
    }

    private String createInputString(String givenInput) {
        return givenInput + NEW_LINE;
    }

    private ByteArrayInputStream convertForInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("입력 금액은 숫자만 가능하다.")
    @Test
    void throw_exception_when_receives_non_numeric_amount() {
        //given
        String given = "adfasd";
        setIn(given);
        InputView inputView = new InputView();

        //when, then
        assertThatThrownBy(inputView::inputAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
