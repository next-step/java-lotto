package lottogame.domain.lotto;

import lottogame.domain.strategy.PredefinedLottoNumberStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6"));
        LottoNumber bonusNumber = new LottoNumber(7);
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @DisplayName("일치하는 번호의 개수를 정확히 계산한다")
    @Test
    void countMatchingNumbers() {
        Lotto otherLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,7,8,9"));

        assertEquals(3, winningLotto.countMatchingNumbers(otherLotto));
    }

    @DisplayName("보너스 번호가 일치하는지 정확히 판단한다")
    @Test
    void isMatchingBonus() {
        Lotto matchingBonusLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,7"));
        Lotto notMatchingBonusLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,8"));

        assertTrue(winningLotto.isMatchingBonus(matchingBonusLotto));
        assertFalse(winningLotto.isMatchingBonus(notMatchingBonusLotto));
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복될 경우 예외가 발생한다.")
    @Test
    void throwExceptionForDuplicationNumber() {
        Lotto winningLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6"));
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(winningLotto, bonusNumber);
        });
    }

}
