package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {


    @Test
    @DisplayName("총 금액과 수동 수량을 입력하면 구매할 수 있는지 확인한다.")
    void 구매_가능_확인() {
        assertThatThrownBy(() -> LottoGame.getInstance().validateBuy(3000, 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동 로또를 산 수량 만큼 금액을 반환한다.")
    void 수동_로또_구매() {
        assertThat(LottoGame.getInstance().buyManual(7000, 3)).isEqualTo(4000);
    }

    @Test
    @DisplayName("금액이 1000원 미만이면 빈 리스트 반환")
    void 금액_부족() {
        assertThat(LottoGame.getInstance().buyAuto(999).getLottos()).isEmpty();
    }

    @Test
    @DisplayName("구입한 로또 금액만큼 로또 결과를 반환한다.")
    void 로또금액만큼_결과() {
        assertThat(LottoGame.getInstance().buyAuto(14000).getSize()).isEqualTo(14);
    }
}
