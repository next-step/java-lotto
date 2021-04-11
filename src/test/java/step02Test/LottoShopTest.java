package step02Test;

import org.junit.jupiter.api.BeforeEach;
import step02.InputNumberRule;
import step02.LottoShop;

public class LottoShopTest {

    private LottoShop lottoShop = new LottoShop();

    @BeforeEach
    void setLottoShop() {
        lottoShop.buyLotto(new InputNumberRule("7, 8, 10, 20, 40, 44"));
    }
}
