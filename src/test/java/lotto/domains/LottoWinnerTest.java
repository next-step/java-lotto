package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoWinnerTest {
    @Test
    void testDuplicatedBonusNumberToLotto() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(1);

        assertThatThrownBy(() -> new LottoWinner(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
