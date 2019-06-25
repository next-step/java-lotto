package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("6개의 로또번호와 1개의 보너스 번호를 갖는 당첨번호 생성한다")
    @Test
    void createWinningLotto() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Number bonus = Number.of(7);

        WinningLotto winningLotto = WinningLotto.generate(lotto, bonus);

        assertThat(winningLotto).isNotNull();
        assertThat(winningLotto).isEqualTo(new WinningLotto(ofLotto(1, 2, 3, 4, 5, 6), Number.of(7)));
    }

    @DisplayName("6개가 모두 일치할 시 1등")
    @Test
    void matchOtherLottoThenFirst() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Number bonus = Number.of(7);
        WinningLotto winningLotto = WinningLotto.generate(lotto, bonus);

        Prize result = winningLotto.getResultOf(lotto);
        assertThat(result).isEqualTo(Prize.FIRST);
    }

    @DisplayName("5개 번호와 보너스 일치 할 시 2등")
    @Test
    void matchOtherLottoThenSecond() {
        Lotto confirmLotto = ofLotto(1, 2, 3, 4, 5, 7);
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Number bonus = Number.of(7);
        WinningLotto winningLotto = WinningLotto.generate(lotto, bonus);

        Prize result = winningLotto.getResultOf(confirmLotto);
        assertThat(result).isEqualTo(Prize.SECOND);
    }

    @DisplayName("5개 번호만 일치 할 시 3등")
    @Test
    void matchOtherLottoThenThird() {
        Lotto confirmLotto = ofLotto(1, 2, 3, 4, 5, 8);
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Number bonus = Number.of(7);
        WinningLotto winningLotto = WinningLotto.generate(lotto, bonus);

        Prize result = winningLotto.getResultOf(confirmLotto);
        assertThat(result).isEqualTo(Prize.THIRD);
    }

    @DisplayName("2개 번호만 일치 할 시 꽝")
    @Test
    void matchOtherLottoThenNone() {
        Lotto confirmLotto = ofLotto(1, 2, 8, 9, 10, 11);
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Number bonus = Number.of(7);
        WinningLotto winningLotto = WinningLotto.generate(lotto, bonus);

        Prize result = winningLotto.getResultOf(confirmLotto);
        assertThat(result).isEqualTo(Prize.NONE);
    }
}
