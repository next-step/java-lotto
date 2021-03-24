package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 당첨 번호 생성")
    public void create() throws Exception {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(numbers));
    }

    @Test
    @DisplayName("당첨 번호 길이가 6자 이외일 경우 예외")
    public void checkLength() throws Exception {
        List<String> overSix = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(overSix));
        List<String> lowerSix = Arrays.asList("1", "2", "3", "4", "5");
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(lowerSix));
    }

    @Test
    @DisplayName("당청 번호의 요소 모두 정수가 아닐 경우 예외")
    public void checkInteger() throws Exception {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "X");
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(numbers));
    }

    @Test
    @DisplayName("당첨 번호의 요소 범위가 1 ~ 45가 아닐 경우 예외")
    public void checkBound() throws Exception {
        List<String> overMax = Arrays.asList("1", "2", "3", "4", "5", "46");
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(overMax));
        List<String> lowerMin = Arrays.asList("0", "2", "3", "4", "5", "45");
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(lowerMin));
    }

    @Test
    @DisplayName("당첨 번호 중 중복되는 숫자가 존재할 경우")
    public void checkDuplication() throws Exception {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "5");
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(numbers));
    }
}
