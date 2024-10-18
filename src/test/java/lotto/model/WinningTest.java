package lotto.model;

import lotto.model.dto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.Winning.INVALID_BONUS_NUMBER;
import static lotto.model.dto.LottoNumber.of;

public class WinningTest {
    @Test
    void 생성() {
        Lotto winningLotto = new Lotto(() -> Arrays.asList(of(1), of(2), of(3), of(4), of(5), of(6)));
        LottoNumber bonusNumber = of(7);

        Winning winning = Winning.of(winningLotto, bonusNumber);
        Lotto actualWinningLotto = winning.winningLotto();
        LottoNumber actualBonusNumber = winning.bonusNumber();

        Assertions.assertThat(actualWinningLotto).isEqualTo(winningLotto);
        Assertions.assertThat(actualBonusNumber).isEqualTo(bonusNumber);
    }

    @Test
    void 당첨번호목록_보너스번호_중복() {
        Lotto winningLotto = new Lotto(() -> Arrays.asList(of(1), of(2), of(3), of(4), of(5), of(6)));
        LottoNumber bonusNumber = of(6);
        Assertions.assertThatThrownBy(() -> {
                    Winning duplicatedWinning = Winning.of(winningLotto, bonusNumber);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BONUS_NUMBER);
    }

    @Test
    void 당첨번호목록_() {
    }
}
