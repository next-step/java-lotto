package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoShopTest {
    @Test
    public void 로또_횟수_확인() {
        LottoShop lottoShop = new LottoShop(5000);
        assertThat(lottoShop.getBuyRound()).isEqualTo(5);
    }

    @Test
    public void 로또_최하금액_확인() {
        assertThatThrownBy(() ->{
            new LottoShop(800);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
