package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoGameTest {
    @DisplayName("구입 금액에서 로또 개수 계산 테스트")
    @Test
    void available_lotto_quantity() {
        assertThat(new LottoGame(14560)).extracting("count").isEqualTo(14);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoGame(0));
    }

    @DisplayName("로또 당첨 수익률 계산 테스트")
    @Test
    void calculate_earning_rate() {
        LottoGame lottoGame = new LottoGame(new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1)),
                        new Lotto(Arrays.asList(35, 23, 5, 9, 3, 8))
                )
        ));
        lottoGame.draw(Arrays.asList(6, 5, 4, 3, 2, 1));

        assertThat(lottoGame.calculateEarningRate())
                .isEqualTo(1000000);
    }
}
