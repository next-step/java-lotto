package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CombinedLottosTest {
    @Test
    void 로또_여러_장을_구매할_경우_수동과_자동이_몇_장_씩인지_알_수_있다() {
        Lotto lotto1 = Lotto.from("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = Lotto.from("1, 2, 3, 4, 5, 7");
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        CombinedLottos combinedLottos = LottoShop.sell(3000, lottos);
        assertThat(combinedLottos.getAutoLottoQuantity()).isEqualTo(1);
        assertThat(combinedLottos.getManualLottoQuantity()).isEqualTo(2);
    }

    @Test
    void 수동과_자동을_함께_구매하면_하나의_lottos로_반환된다() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        Lottos lottos = new Lottos(List.of(lotto));
        CombinedLottos combinedLottos = LottoShop.sell(3000, lottos);
        assertThat(combinedLottos.getCombinedLottos().getLottoQuantity()).isEqualTo(3);
        assertThat(combinedLottos.getCombinedLottos().getLottoList().contains(lotto)).isTrue();
    }
}
