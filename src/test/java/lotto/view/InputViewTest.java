package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    @DisplayName("사용자로부터 구입 금액을 콘솔에 입력을 받아 해당 값을 반환합니다.")
    void test01() {
        String expected = "1000";

        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        int actual = createInputView().showPaymentConsole();

        assertThat(actual).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("사용자로부터 지난주 당첨번호를 콘솔에 입력을 받아 해당 값을 반환합니다.")
    void test02() {
        String expected = "1, 2, 3, 4, 5, 6";

        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        String actual = createInputView().showLastWeekWinningNumbersConsole();

        assertThat(actual).isEqualTo(expected);
    }

    private InputView createInputView() {
        return new InputView(new Scanner(System.in));
    }

}