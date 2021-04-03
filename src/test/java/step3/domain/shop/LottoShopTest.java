package step3.domain.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoShopTest {

    @DisplayName("LottoShop 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoShop lottoShop = LottoShop.getInstance();

        // then
        assertThat(lottoShop).isNotNull();
    }

    @DisplayName("LottoShop 인스턴스 로또 반환 여부 테스트")
    @Test
    void 반환_로또() {
        // given
        int money = 1000;

        // when
        LottoShop lottoShop = LottoShop.getInstance();
        List<Lotto> lottos = lottoShop.getLottos(money);

        // then
        assertAll(
                () -> assertThat(lottos).isNotNull(),
                () -> assertThat(lottos.size()).isEqualTo(1)
        );
    }

}