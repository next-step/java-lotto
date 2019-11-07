package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/05.
 */
public class InputViewTest {

    @DisplayName("구입 금액 입력")
    @ParameterizedTest
    @CsvSource(value = {"14000:14000", "1000:1000"}, delimiter = ':')
    void receiveAmount(String input, int output) {

        // given
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputView inputView = new InputView(in);

        // when
        int amount = inputView.receiveAmount();

        //then
        assertThat(amount).isEqualTo(output);

    }

    @DisplayName("당첨 번호 입력")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "15, 2:2"}, delimiter = ':')
    void receiveWinningNumbers(String input, int size) {

        // given
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputView inputView = new InputView(in);

        // when
        List<Integer> winningNumbers = inputView.receiveWinningNumbers();

        //then
        assertThat(winningNumbers).hasSize(size);

    }

    @DisplayName("보너스 번호 입력")
    @ParameterizedTest
    @CsvSource(value = {"6:6", "7:7"}, delimiter = ':')
    void receiveBonusNumber(String input, int bonus) {

        // given
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        InputView inputView = new InputView(in);

        // when
        int bonusNumber = inputView.receiveBonusNumber();

        //then
        assertThat(bonusNumber).isEqualTo(bonus);

    }
}
