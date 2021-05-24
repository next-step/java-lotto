package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {

    @Test
    @DisplayName("로또 구입금액 입력시 해당 금액만큼 로또 구매")
    void buyLottos() {
        long price = 14_000L;
        LottoShop lottoShop = new LottoShop();

        Lottos lottos = lottoShop.buyLottos(price, Collections.EMPTY_LIST);

        assertThat(lottos.getValues()).hasSize(14);
    }

    @Test
    @DisplayName("수동 로또 구매 - 구입금액에서 수동 구매 갯수 제외 나머지는 자동구매")
    void buyManualLottos() {
        long price = 14_000L;
        LottoShop lottoShop = new LottoShop();
        LottoNumbers manualNumbers_1 = new LottoNumbers(8, 21, 23, 41, 42, 43);
        LottoNumbers manualNumbers_2 = new LottoNumbers(3, 5, 11, 16, 32, 38);
        LottoNumbers manualNumbers_3 = new LottoNumbers(7, 11, 16, 35, 36, 44);

        Lottos lottos = lottoShop.buyLottos(price, Arrays.asList(manualNumbers_1, manualNumbers_2, manualNumbers_3));

        assertThat(lottos.getAutos()).hasSize(11);
        assertThat(lottos.getManuals()).hasSize(3);
        assertThat(lottos.getManuals()).contains(new Lotto(manualNumbers_1, LottoType.MANUAL),
                new Lotto(manualNumbers_2, LottoType.MANUAL), new Lotto(manualNumbers_3, LottoType.MANUAL));
    }
}
