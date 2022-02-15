package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void 중복된_숫자가_들어오면_예외를_발생하는지_확인() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "5");
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new WinningNumber(numbers, new LottoNumber(9)));
    }

    @Test
    void 다섯개의_숫자가_들어오면_예외를_발생하는지_확인() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new WinningNumber(numbers, new LottoNumber(9)));
    }

    @Test
    void 일곱개의_숫자가_들어오면_예외를_발생하는지_확인() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new WinningNumber(numbers, new LottoNumber(9)));
    }

    @Test
    void 보너스볼이_있는지_체크() {
        WinningNumber winningNumber = new WinningNumber(
            Arrays.asList("2", "4", "8", "15", "20", "21"), new LottoNumber(41));
        boolean bonusBallMatch = winningNumber.isContainBonusBall(Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41),
            new LottoNumber(15),
            new LottoNumber(20)));
        assertThat(bonusBallMatch).isEqualTo(true);
    }
}