package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottosTest {
    @DisplayName("구입금액을 입력하면 금액에 해당하는 로또가 발급된다.")
    @Test
    void lottosInit() {
        //given
        final Lottos lottos = new Lottos(new Amount(14500));

        //when
        final int result = lottos.purchaseCount();

        //then
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("로또 당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void drawBonusNumberDuplicateTest() {
        final Lottos lottos = new Lottos(new Amount(14500));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottos.draw(new WinningNumber(new Lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(6)));
        });
    }

    @DisplayName("로또 번호 6개가 전부 일치하면 FIRST RANK를 가지는 Winning을 리턴한다.")
    @Test
    void drawTest() {
        //given
        final Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        final Lottos lottos = new Lottos(Arrays.asList(lotto));

        //when
        final Winning winning = lottos.draw(new WinningNumber(new Lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(7)));


        //then
        assertThat(winning).isEqualTo(new Winning(Map.of(Rank.FIRST, 1)));
    }
}