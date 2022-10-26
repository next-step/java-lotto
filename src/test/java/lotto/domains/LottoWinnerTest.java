package lotto.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoWinnerTest {
    @Test
    void testDuplicatedBonusNumberToLotto() {
        Lotto lotto = LottoGenerator.INSTANCE.createLotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = LottoNumber.of(1);

        assertThatThrownBy(() -> new LottoWinner(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testSuccessIsBonusNumber() {
        Lotto lotto = LottoGenerator.INSTANCE.createLotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = LottoNumber.of(7);
        LottoWinner winner = new LottoWinner(lotto, bonusNumber);

        assertThat(winner.isBonus(bonusNumber)).isTrue();
    }
}
