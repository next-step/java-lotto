package lotto.model;

import lotto.model.dto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lotto.model.Winning.INVALID_BONUS_NUMBER;

public class WinningTest {
    @Test
    void 생성() {
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);

        Winning winning = new Winning(winningLotto, bonusNumber);
        Lotto actualWinningLotto = winning.winningLotto();
        LottoNumber actualBonusNumber = winning.bonusNumber();

        Assertions.assertThat(actualWinningLotto).isEqualTo(winningLotto);
        Assertions.assertThat(actualBonusNumber).isEqualTo(bonusNumber);
    }

    @Test
    void 당첨번호목록_보너스번호_중복() {
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(6);
        Assertions.assertThatThrownBy(() -> {
                    Winning duplicatedWinning = new Winning(winningLotto, bonusNumber);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BONUS_NUMBER);
    }
}
