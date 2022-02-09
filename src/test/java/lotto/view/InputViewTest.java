package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("구입 금액 입력을 입력받는다.")
    @ValueSource(strings = {"1450 0", "1500",})
    @ParameterizedTest
    void 구입_금액_입력을_입력받는다(String input) {
        // given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when
        String expected = InputView.inputBudget();

        // then
        assertThat(expected).isEqualTo(input);
    }

    @DisplayName("숫자 사이 공백이 있는 경우 공백을 제거하고 반환한다.")
    @Test
    void _When_공백이_있는_입력_Then_공백을_제거하고_반환() {
        // given
        InputStream inputStream = new ByteArrayInputStream("1, 2, 3, 4, 5, 6".getBytes());
        System.setIn(inputStream);

        // when
        String returnValue = InputView.inputWinningNumbers();

        // then
        assertThat(returnValue).isEqualTo("1,2,3,4,5,6");
    }
}
