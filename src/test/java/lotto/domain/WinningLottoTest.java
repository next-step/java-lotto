package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private static final int BONUS_NUMBER = 10;

    @DisplayName("당첨 확인")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 6:6"}, delimiter = ':')
    void checkWinning(String lottoNumber, String winningNumber, int expected) {
        Lotto buyingLotto = Lotto.manual(lottoNumber);
        WinningLotto winningLotto = new WinningLotto(winningNumber, BONUS_NUMBER);

        int actual = winningLotto.checkWinning(buyingLotto).getMatchCount();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("2등 당첨 확인")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 7:6"}, delimiter = ':')
    void checkSecond(String lottoNumber, String winningNumber, int bonusNumber) {
        Lotto buyingLotto = Lotto.manual(lottoNumber);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        String actual = winningLotto.checkWinning(buyingLotto).name();

        assertThat(actual).isEqualTo(WinningType.SECOND.name());
    }
}