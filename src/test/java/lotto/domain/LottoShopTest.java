package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoShopTest {

    @Test
    @DisplayName("수동 로또 입력 받은 후 자동,수동 생성")
    void buyTest() {
        LottoShop lottoShop = new LottoShop(new LottoFee(4000));

        Lottos lottos = lottoShop.buy(List.of(
                List.of(1,2,3,4,5,6),
                List.of(10,11,23,34,41,45)));

        assertThat(lottos.getValue()).contains(
                Lotto.create(List.of(1,2,3,4,5,6)),
                Lotto.create(List.of(10,11,23,34,41,45)));
    }
}