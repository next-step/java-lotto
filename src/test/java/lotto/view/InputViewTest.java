package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("구입 금액 입력을 입력을 때 사이 공백 등 불필요한 공백을 제거한다.")
    @Test
    void When_공백이_있는_구매_금액_입력_Then_공백을_제거하고_반환() {
        InputStream inputStream = new ByteArrayInputStream("14 0 0".getBytes());
        System.setIn(inputStream);

        String output = InputView.inputBudget();

        assertThat(output).isEqualTo("1400");
    }

    @DisplayName("보너스 번호 을 입력을 때 사이 공백 등 불필요한 공백을 제거한다.")
    @Test
    void When_공백이_있는_보너스_번호_입력_Then_공백을_제거하고_반환() {
        InputStream inputStream = new ByteArrayInputStream("1 4".getBytes());
        System.setIn(inputStream);

        String output = InputView.inputBonusNumber();

        assertThat(output).isEqualTo("14");
    }

    @DisplayName("숫자 사이 공백이 있는 경우 공백을 제거하고 반환한다.")
    @Test
    void When_공백이_있는_당첨번호_입력_Then_공백을_제거하고_반환() {
        InputStream inputStream = new ByteArrayInputStream("1, 2, 3, 4, 5, 6".getBytes());
        System.setIn(inputStream);

        String returnValue = InputView.inputWinningNumbers();

        assertThat(returnValue).isEqualTo("1,2,3,4,5,6");
    }

    @DisplayName("입력으로 공백만 들어오면 예외를 발생시킨다.")
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    @ParameterizedTest
    void When_공백_Then_예외_발생(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(IllegalArgumentException.class, () -> InputView.inputBudget());
    }
}
