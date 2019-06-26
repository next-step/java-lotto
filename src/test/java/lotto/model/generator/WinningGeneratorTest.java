package lotto.model.generator;

import lotto.exception.DuplicateLottoNumberException;
import lotto.model.Number;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningGeneratorTest {

    @DisplayName("당첨 번호를 생성한다")
    @Test
    void createWinningLotto() {
        String numbers = "1,2,3,4,5,6";
        int bonus = 7;

        WinningLotto winningLotto = WinningGenerator.generate(numbers, bonus);

        assertThat(winningLotto.getLotto()).isEqualTo(ofLotto(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getBonus()).isEqualTo(Number.of(bonus));
    }

    @DisplayName("보너스 번호가 중복일 시 에러")
    @Test
    void generateDuplicateBonusNumberThenFail() {
        String numbers = "1,2,3,4,5,6";
        int bonus = 6;
        assertThatExceptionOfType(DuplicateLottoNumberException.class)
                .isThrownBy(() -> WinningGenerator.generate(numbers, bonus));
    }
}