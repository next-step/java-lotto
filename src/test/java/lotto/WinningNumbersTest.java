package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 당첨 번호 생성")
    public void create() throws Exception {
        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(numbers));
    }
}
