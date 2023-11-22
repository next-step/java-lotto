package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumbersTest {
    @Test
    @DisplayName("isSame 은 주어진 로또 번호와 당첨 로또 번호가 같으면 true 를 반환한다")
    void isSame_lottoWinningNumbersWithSameNumbers_true() {
        Lotto lottoNumbers = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers, bonusNumber);

        boolean isSame = lottoWinningNumbers.isSame(lottoNumbers);

        assertThat(isSame).isTrue();
    }

    @Test
    @DisplayName("isSame 은 주어진 로또 번호와 당첨 로또 번호가 다르면 false 를 반환한다")
    void isSame_lottoWinningNumbersWithDifferentNumbers_false() {
        Lotto differentNumbers = new Lotto("1, 2, 3, 4, 5, 7");
        Lotto lottoNumbers = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = new LottoNumber(8);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers, bonusNumber);

        boolean isSame = lottoWinningNumbers.isSame(differentNumbers);

        assertThat(isSame).isFalse();
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("LottoWinningNumbers 는 아무런 로또번호가 주어지지 않으면 예외를 던진다")
    void newObject_nullLotto_throwsException(Lotto nullLotto) {
        LottoNumber bonusNumber = new LottoNumber(8);

        assertThatThrownBy(
            () -> new LottoWinningNumbers(nullLotto, bonusNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
