package calculator.view;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @DisplayName("white space로 문자열을 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"6 + 5 - 4 * 3 / 2"})
    void receiveFormula(String input) {
        InputView inputView = setIn(input);
        List<String> expected = Arrays.asList("6", "+", "5", "-", "4", "*", "3", "/", "2");

        List<String> actual = inputView.receiveFormula();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("분리된 문자리스트의 길이가 3이하인 경우 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"6 + "})
    void receiveFormula_min_length(String input) {
        InputView inputView = setIn(input);

        ThrowingCallable actual = inputView::receiveFormula;

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 숫자 2개와 연산자 하나를 입력해야합니다. ex) 1 + 2");
    }

    @DisplayName("분리된 문자리스트의 길이가 짝수인경우 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"6 + 5 -"})
    void receiveFormula_even_size(String input) {
        InputView inputView = setIn(input);

        ThrowingCallable actual = inputView::receiveFormula;

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자와 숫자 개수의 합은 짝수일 수 없습니다. 숫자로 끝나는 정확한 계산식을 입력하세요.");
    }

    @DisplayName("분리된 문자리스트의 짝수 인덱스 문자가 숫자가 아닌경우 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"5 + +"})
    void receiveFormula_even_index_is_number(String input) {
        InputView inputView = setIn(input);

        ThrowingCallable actual = inputView::receiveFormula;

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 위치에 숫자가 아닌 값이 입력되었습니다. 숫자 연산자 숫자 순으로 번갈아가며 입력해주세요.");
    }

    @DisplayName("분리된 문자리스트의 홀수 인덱스의 문자가 사칙연산기호(+,-,*,%)가 아닌경우 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"5 4 5"})
    void receiveFormula_odd_index_is_operator(String input) {
        InputView inputView = setIn(input);

        ThrowingCallable actual = inputView::receiveFormula;

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자(+,-,*,/)의 위치에 연산자가 아닌 값이 입력되었습니다.");
    }

    private InputView setIn(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        return new InputView();
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
