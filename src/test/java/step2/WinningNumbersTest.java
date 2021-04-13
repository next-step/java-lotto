package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}
