package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("구입 금액 입력을 입력받는다.")
    @ValueSource(strings = {"1450 0", "1500", })
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
}
