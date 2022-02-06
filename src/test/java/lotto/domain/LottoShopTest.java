package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoShopTest {

    @Test
    void 로또를_사기위한_최소금액은_1000원_이상이다() {
        LottoShop lottoShop = new LottoShop();

        assertThatThrownBy(() -> lottoShop.countPossibleLottoAmount(500))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("최소 1000원이어야 합니다.");
    }

    @Test
    void 로또를_사기위한_금액은_1000원_단위여야_한다() {
        LottoShop lottoShop = new LottoShop();

        assertThatThrownBy(() -> lottoShop.countPossibleLottoAmount(1230))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("투입한 금액이 1000원 단위가 아닙니다.");
    }

    @Test
    void 투입한_금액만큼_로또를_살_수_있다() {
        LottoShop lottoShop = new LottoShop();

        lottoShop.countPossibleLottoAmount(5000);
        Lottos lottos = lottoShop.buyLotto();

        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }

}
