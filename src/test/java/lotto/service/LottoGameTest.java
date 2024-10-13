package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    @DisplayName("금액이 1000원 미만이면 exception 발생")
    void 금액_부족() {
        assertThatThrownBy(() -> LottoGame.getInstance().buy(999))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("구입한 로또 금액만큼 로또 결과를 반환한다.")
    void 로또금액만큼_결과() {
        assertThat(LottoGame.getInstance().buy(14000)).hasSize(14);
    }
}
