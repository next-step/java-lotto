package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨번호가 저장되는지 테스트")
    void inputWinningNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1,2,45,11,7,17);
        LottoNumberGenerator lottoNumberGenerator = new TestLottoNumberGenerator(numbers);

        // when
        WinningNumbers winningNumbers = new WinningNumbers(lottoNumberGenerator);
        List<Integer> actual = winningNumbers.getWinningNumbers();

        // then
        assertThat(actual).contains(1,2,45,11,7,17);
    }

    @Test
    @DisplayName("당첨번호에 중복번호 있을때 RuntimeException 던지는지 테스트")
    void isThrowRuntimeException() {
        // given
        List<Integer> numbers = Arrays.asList(1,2,46,11,7,17);
        LottoNumberGenerator lottoNumberGenerator = new TestLottoNumberGenerator(numbers);

        // then
        assertThrows(RuntimeException.class, () -> {
            WinningNumbers winningNumbers = new WinningNumbers(lottoNumberGenerator);
        });
    }

    @Test
    @DisplayName("당첨번호와 비교하여 결과가 Map에 담기는지 테스트")
    void compareToWinningNumbers() {
        // given
        int numberOfLotto = 3;
        List<Integer> myLottoNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoNumberGenerator lottoNumberGenerator = new TestLottoNumberGenerator(myLottoNumbers);
        LottoTickets myLotto = new LottoTickets(numberOfLotto, lottoNumberGenerator);

        // when
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);
        LottoNumberGenerator winningNumberGenerator = new TestLottoNumberGenerator(winningNumber);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberGenerator);
        winningNumbers.compareToWinningNumbers(myLotto);
        Map<Integer, Integer> result = winningNumbers.getMatchCountMap();

        // then
        int expected = numberOfLotto;
        int actual = result.get(PrizeMoney.MATCH_NUMBERS_NEED_TO_FIRST_GRADE);
        assertEquals(expected, actual);
    }
}
