package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaserTest {

    @Test
    @DisplayName("자동 로또 정보와 수동 로또 정보가 주어지면 개수에 맞게 로또를 구매한다.")
    void 자동_수동_로또_구매() {
        // given
        LottoPurchaser purchaser = new LottoPurchaser(new LottoFactory());

        Automatic automatic = new Automatic(new LottoMoney(14000));
        Manuals manuals = new Manuals(List.of(
                List.of(1, 2, 3, 4, 5, 6)), new LottoMoney(new ManualLottoCount(1)));

        // when
        PurChasedLottos purchaseLotto = purchaser.purchaseLotto(automatic, manuals);

        // then
        assertThat(purchaseLotto.getLottos().size()).isEqualTo(15);
        assertThat(purchaseLotto.getAutoCount()).isEqualTo(14);
        assertThat(purchaseLotto.getManualCount()).isEqualTo(1);
        assertThat(purchaseLotto.getMoney()).isEqualTo(15000);
    }

}
