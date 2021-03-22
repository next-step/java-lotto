package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 당첨 번호 생성")
    public void create() throws Exception {
        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(numbers));
    }

    @Test
    @DisplayName("당첨 번호 길이가 6자 이외일 경우 예외")
    public void checkLength() throws Exception {
        String[] overSix = {"1", "2", "3", "4", "5", "6", "7"};
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(overSix));
        String[] lowerSix = {"1", "2", "3", "4", "5"};
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(lowerSix));
    }

    @Test
    @DisplayName("당청 번호의 요소 모두 정수가 아닐 경우 예외")
    public void checkInteger() throws Exception {
        String[] numbers = {"1", "2", "3", "4", "5", "X"};
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(numbers));
    }
}
