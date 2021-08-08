package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("당첨 번호 컬렉션 테스트")
public class WinningNumbersTest {

    @DisplayName("당첨 번호가 6개가 아니면, Exception이 발생한다.")
    @Test
    public void winningNumberCountExceptionTest() {
        // given
        List<Integer> fiveNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sevenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(fiveNumbers))
                .withMessage("당첨 번호는 6개 이어야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(sevenNumbers))
                .withMessage("당첨 번호는 6개 이어야 합니다.");
    }

    @DisplayName("당첨 번호가 중복 되었을 때, Exception이 발생한다.")
    @Test
    public void duplicatedWinningNumberExceptionTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(numbers))
                .withMessage("당첨 번호가 중복 되었습니다.");
    }

    @DisplayName("당첨 번호 포함 여부 기능이 정상 동작해야 한다.")
    @Test
    public void containsTest() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when, then
        assertTrue(winningNumbers.contains(LottoNumber.valueOf(1)));
        assertTrue(winningNumbers.contains(LottoNumber.valueOf(6)));
        assertFalse(winningNumbers.contains(LottoNumber.valueOf(7)));
    }
}
