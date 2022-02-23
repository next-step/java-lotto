package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("중복된_숫자가_들어오면_예외를_발생하는지_확인")
    @Test
    void when_winning_numbers_duplicates_throw_exception() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new WinningNumber(numbers, 9));
    }

    @Test
    void when_size_of_winning_numbers_less_than_six_throw_exception() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new WinningNumber(numbers, 9));
    }

    @Test
    void when_size_of_winning_numbers_more_than_six_throw_exception() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new WinningNumber(numbers, 9));
    }

    @DisplayName("로또에서 몇개의 당첨 번호가 일치 하는지 체크한다.")
    @Test
    void findMatchingCount() {
        WinningNumber winningNumber = new WinningNumber(
            Arrays.asList(2, 4, 8, 15, 20, 21), 41);
        List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41),
            new LottoNumber(15),
            new LottoNumber(20));
        assertThat(winningNumber.findMatchingCount(lottoNumbers)).isEqualTo(5);
    }

    @DisplayName("로또에 보너스볼이 번호가 있는지 체크")
    @Test
    void isContainBonsuBall() {
        WinningNumber winningNumber = new WinningNumber(
            Arrays.asList(2, 4, 8, 15, 20, 21), 41);
        boolean bonusBallMatch = winningNumber.isContainBonusBall(Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41),
            new LottoNumber(15),
            new LottoNumber(20)));
        assertThat(bonusBallMatch).isEqualTo(true);
    }
}
