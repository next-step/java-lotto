import Lotto.domain.LottoNumber;
import Lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @Test
    void should_throw_exception_when_winning_numbers_are_not_six() {
        List<LottoNumber> invalidNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5) // 5개 (부족함)
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumbers(invalidNumbers)
        );

        assertEquals("당첨 번호는 6자리여야 합니다.", exception.getMessage());
    }

    @Test
    void should_return_correct_winning_numbers() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );

        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        assertEquals(6, winningNumbers.getNumbers().size());
        assertTrue(winningNumbers.getNumbers().contains(new LottoNumber(3)));
    }
}
