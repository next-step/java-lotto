package lotto.domain.sales;

import lotto.constant.ErrorMessage;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.prize.LottoPrize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), 8);
        assertThat(winningLotto).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,7", "1,2,3,4,5,8"})
    void 로또를_비교하여_당첨_등수_반환(String text) {
        Lotto winning = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        WinningLotto winningLotto = new WinningLotto(winning, bonus);

        Lotto first = new Lotto(text);

        assertThat(winningLotto.lottoPrize(first))
                .isEqualTo(LottoPrize.from(winning.match(first), first.has(new LottoNumber(bonus))));
    }

    @Test
    void 보너스번호와_로또번호_중복_예외발생() {
        LottoNumber bonus = new LottoNumber(6);
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");

        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(winningLotto, bonus))
                .withMessage(String.format(ErrorMessage.INVALID_BONUS_NUMBER.getMessage(), winningLotto));
    }
}
