package step4.domain.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.lotto.Lotto;
import step4.domain.money.Money;
import step4.strategy.LottoShuffleStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest {

    @DisplayName("LottoShop 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        LottoShop lottoShop = LottoShop.getInstance();

        // then
        assertThat(lottoShop).isNotNull();
    }

    @DisplayName("LottoShop 인스턴스가 돈에 맞는 로또 반환 여부 테스트")
    @Test
    void 반환_로또() {
        // given
        Money money = Money.valueOf(1000);
        LottoShuffleStrategy strategy = lottoNumbers -> {};

        // when
        LottoShop lottoShop = LottoShop.getInstance();
        List<Lotto> lottos = lottoShop.purchaseLotto(money, strategy);

        // then
        assertThat(lottos).isNotNull();
    }

}