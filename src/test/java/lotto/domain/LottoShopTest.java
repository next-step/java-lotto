package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoShopTest {
    @Test
    void 로또_게임수_확인() {
        LottoShop lottoShop = new LottoShop(5000, 3);
        assertThat(lottoShop.getBuyRound()).isEqualTo(5);
    }

    @Test
    void 로또_최하금액_IllegalArgumentException() {
        assertThatThrownBy(() ->{
            new LottoShop(800, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동_로또_게임수_확인() {
        LottoShop lottoShop = new LottoShop(5000, 3);
        assertThat(lottoShop.getManualRound()).isEqualTo(3);
    }

    @Test
    void 수동_로또_게임수_과입력_IllegalArgumentException() {
        assertThatThrownBy(() ->{
            new LottoShop(5000, 7);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동_로또_게임수_확인() {
        LottoShop lottoShop = new LottoShop(5000, 3);
        assertThat(lottoShop.getAutoRound()).isEqualTo(2);
    }
}
