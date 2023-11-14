package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGameTest {
    @DisplayName("구입금액을 입력하면 금액에 해당하는 로또가 발급된다.")
    @Test
    void lottoGameInit() {
        //given
        final LottoGame lottoGame = new LottoGame(new Amount(14500));

        //when
        final int result = lottoGame.purchaseCount();

        //then
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("로또 금액보다 낮은 금액은 예외가 발생한다.")
    @Test
    void smallAmountTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoGame(new Amount(500));
        });
    }
}