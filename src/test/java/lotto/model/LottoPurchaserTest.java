package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaserTest {

    @Test
    @DisplayName("로또 금액이 들어가면 몇개의 로또를 사는지 테스트")
    void 금액만큼_로또_구매() {
        // given
        LottoPurchaser purchaser = new LottoPurchaser(new AutoLottoGenerator());

        // when
        PurChasedLottos purchaseLotto = purchaser.purchaseLotto(new LottoMoney(14000));

        // then
        assertThat(purchaseLotto.getLottoCount()).isEqualTo(14);
    }


}
