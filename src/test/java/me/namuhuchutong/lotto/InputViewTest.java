package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import me.namuhuchutong.lotto.domain.Number;
import me.namuhuchutong.lotto.domain.Numbers;
import me.namuhuchutong.lotto.ui.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("사용자에게 6개 숫자 입력을 받아서 Numbers 객체를 반환한다.")
    @Test
    void test() {
        //given
        String given = "1, 2, 3, 4, 5, 6";
        Numbers expected = new Numbers(
                List.of(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)));
        setIn(given);
        InputView inputView = new InputView();

        //when
        Numbers result = inputView.showNumbersPrompt();

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 입력이 존재할 경우 에외가 발생한다.")
    @Test
    void test2() {
        //given
        String given = "a, 1, 2, 3, 4";
        setIn(given);
        InputView inputView = new InputView();

        //when, then
        assertThatThrownBy(inputView::showNumbersPrompt)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액은 0 혹은 음수일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void test3(String amount) {
        //given
        setIn(amount);
        InputView inputView = new InputView();

        //when, then
        assertThatThrownBy(inputView::showBuyPrompt)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액은 숫자만 가능하다.")
    @Test
    void test4() {
        //given
        String given = "adfasd";
        setIn(given);
        InputView inputView = new InputView();

        //when, then
        assertThatThrownBy(inputView::showBuyPrompt)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
