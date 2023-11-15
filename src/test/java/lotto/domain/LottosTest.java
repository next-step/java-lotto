package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @DisplayName("당첨 번호는 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또당첨번호_6글자_미만() {
        final Lottos lottos = new Lottos(new Amount(14500));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottos.draw(Arrays.asList(1, 5, 4, 2, 5), 10);
        });
    }

    @DisplayName("로또 당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void drawTest() {
        final Lottos lottos = new Lottos(new Amount(14500));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottos.draw(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        });
    }

}