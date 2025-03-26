package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoGameTest {
    @DisplayName("구입 금액에서 로또 개수 계산 테스트")
    @Test
    void available_lotto_quantity() {
        assertThat(new LottoGame(14560)).extracting("count").isEqualTo(14);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoGame(0));
    }
}
