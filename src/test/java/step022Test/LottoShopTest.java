package step022Test;

import org.junit.jupiter.api.Test;
import step022.LottoShop;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @Test
    void buyLotto() {
        LottoShop lottoShop = new LottoShop();
        assertThat(lottoShop.buyLotto(4000).getLottoCount().getCount()).isEqualTo(4);
    }
}
