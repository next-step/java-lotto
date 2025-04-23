import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void should_throw_exception_when_winning_numbers_are_not_six() {
        List<LottoNumber> invalidNumbers = Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5) // 5개 (부족함)
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumbers(invalidNumbers)
        );

        assertEquals("당첨 번호는 6자리여야 합니다.", exception.getMessage());
    }

    @DisplayName("정상적인 당첨 번호가 반환된다")
    @Test
    void should_return_correct_winning_numbers() {
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
        );

        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        assertEquals(6, winningNumbers.getNumbers().size());
        assertTrue(winningNumbers.getNumbers().contains(LottoNumber.of(3)));
    }
}
