package lotto.model;

import lotto.exception.DuplicateLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    @DisplayName("당첨 번호를 문자열로 입력 시 생성에 성공한다")
    @Test
    void createWinningLotto_Success() {
        String lotto = "1,2,3,4,5,6";
        int bonus = 7;

        WinningLotto winningLotto = WinningLotto.of(lotto, bonus);

        assertThat(winningLotto.getLotto()).isEqualTo(ofLotto(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getBonus()).isEqualTo(Number.of(7));
    }

    @DisplayName("당첨 번호를 생성하는데 성공한다")
    @Test
    void createWinningLotto() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Number bonus = Number.of(7);

        WinningLotto winningLotto = WinningLotto.of(lotto, bonus);

        assertThat(winningLotto.getLotto()).isEqualTo(ofLotto(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getBonus()).isEqualTo(Number.of(7));
    }

    @DisplayName("보너스 번호가 중복일 시 에러")
    @Test
    void generateDuplicateBonusNumberThenFail() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Number bonus = Number.of(6);

        assertThatExceptionOfType(DuplicateLottoNumberException.class)
                .isThrownBy(() -> WinningLotto.of(lotto, bonus));
    }
}