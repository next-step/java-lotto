package lotto.domain.sales;

import lotto.constant.ErrorMessage;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.prize.LottoPrize;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), 8);
        assertThat(winningLotto).isNotNull();
    }

    @Test
    void 로또를_비교하여_당첨_등수_반환() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), 7);
        Lotto first = new Lotto("1,2,3,4,5,6");
        Lotto secondWithBonus = new Lotto("1,2,3,4,5,7");
        Lotto second = new Lotto("1,2,3,4,5,8");

        assertThat(winningLotto.lottoPrize(first)).isEqualTo(LottoPrize.FIRST);
        assertThat(winningLotto.lottoPrize(secondWithBonus)).isEqualTo(LottoPrize.SECOND_WITH_BONUS);
        assertThat(winningLotto.lottoPrize(second)).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    void 보너스번호와_로또번호_중복_예외발생() {
        LottoNumber bonus = new LottoNumber(6);
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");

        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(winningLotto, bonus))
                .withMessage(ErrorMessage.INVALID_BONUS_NUMBER.getMessage()
                        .replace(":winningLotto", winningLotto.toString()));
    }
}
