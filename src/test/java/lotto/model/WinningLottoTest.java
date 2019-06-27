package lotto.model;

import lotto.exception.ConflictLottoNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class WinningLottoTest {

    private Lotto lottoWithWinningNumbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        this.lottoWithWinningNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        this.lotto = new Lotto(Arrays.asList(1,3,5,7,9,11));
    }

    @Test
    @DisplayName("당첨번호 비교")
    void matches() {
        int bonusNumber = 8;
        WinningLotto winningLotto = new WinningLotto(lottoWithWinningNumbers, bonusNumber);

        Prize prize = winningLotto.matches(lotto);
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @Test
    @DisplayName("당첨번호와 보너스 번호가 중복될 경우")
    void conflictLottoNumber() {
        assertThatExceptionOfType(ConflictLottoNumberException.class).isThrownBy(() -> {
            int bonusNumber = 6;
            new WinningLotto(lottoWithWinningNumbers, bonusNumber);
        });
    }
}
