package lotto.model.generator;

import lotto.exception.DuplicateLottoNumberException;
import lotto.model.Lotto;
import lotto.model.Number;
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

        WinningGenerator winningGenerator = WinningGenerator.generate(numbers, bonus);

        Lotto lotto = winningGenerator.generator();
        Number numberOfBonus = winningGenerator.getBonus();

        assertThat(lotto).isEqualTo(ofLotto(1, 2, 3, 4, 5, 6));
        assertThat(numberOfBonus).isEqualTo(Number.of(bonus));
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