package lotto;

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

    @DisplayName("로또 당첨 번호 생성 테스트")
    @Test
    void create_winning_numbers() {
        LottoGame lottoGame = new LottoGame(1000);
        lottoGame.draw(Arrays.asList(6, 5, 4, 3, 2, 1));
        assertThat(lottoGame)
                .extracting("winningLotto")
                .isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
