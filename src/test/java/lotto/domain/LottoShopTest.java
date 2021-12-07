package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {
    @Test
    public void 최소게임_생성(){
        LottoShop lottoShop = new LottoShop(5000);
        assertThat(lottoShop.getBuyRound()).isEqualTo(5);
    }

    @Test
    public void 최소_구매금액_오류(){
        assertThatThrownBy(() -> {
            LottoShop lottoShop = new LottoShop(500);
            lottoShop.getBuyRound();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
