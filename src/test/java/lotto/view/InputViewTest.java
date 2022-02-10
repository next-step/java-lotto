package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("구입 금액 입력을 입력을 때 사이 공백 등 불필요한 공백을 제거한다..")
    @Test
    void When_공백이_있는_구매_금액_입력_Then_공백을_제거하고_반환() {
        // given
        InputStream inputStream = new ByteArrayInputStream("14 0 0".getBytes());
        System.setIn(inputStream);

        // when
        String output = InputView.inputBudget();

        // then
        assertThat(output).isEqualTo("1400");
    }

    @DisplayName("보너스 번호 을 입력을 때 사이 공백 등 불필요한 공백을 제거한다..")
    @Test
    void When_공백이_있는_보너스_번호_입력_Then_공백을_제거하고_반환() {
        // given
        InputStream inputStream = new ByteArrayInputStream("1 4".getBytes());
        System.setIn(inputStream);

        // when
        String output = InputView.inputBonusNumber();

        // then
        assertThat(output).isEqualTo("14");
    }

    @DisplayName("숫자 사이 공백이 있는 경우 공백을 제거하고 반환한다.")
    @Test
    void When_공백이_있는_당첨번호_입력_Then_공백을_제거하고_반환() {
        // given
        InputStream inputStream = new ByteArrayInputStream("1, 2, 3, 4, 5, 6".getBytes());
        System.setIn(inputStream);

        // when
        String returnValue = InputView.inputWinningNumbers();

        // then
        assertThat(returnValue).isEqualTo("1,2,3,4,5,6");
    }
}
