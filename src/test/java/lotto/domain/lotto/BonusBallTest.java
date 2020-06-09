package lotto.domain.lotto;

import lotto.domain.prize.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusBallTest {
    private WinningNumbers winningNumbers = WinningNumbers.create("2, 3, 4, 5, 6, 7");


    @Test
    void 보너스볼은_당첨번호와_중복되지않는다() {
        int bonusBall = 6;
        assertThatThrownBy(() -> BonusBall.create(bonusBall, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 보너스볼은_로또번호_범위_내_값이다(int bonusBall) {
        assertThatCode(() -> BonusBall.create(bonusBall, winningNumbers)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스볼은_로또번호_범위_내_값이다_오(int bonusBall) {
        assertThatThrownBy(() -> BonusBall.create(bonusBall, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }
}