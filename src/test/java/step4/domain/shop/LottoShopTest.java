package step4.domain.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.count.PassiveCount;
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
        Money money = Money.valueOf(4000);
        PassiveCount passiveCount = PassiveCount.valueOf(3);
        int availablePurchaseCount = money.availablePurchaseCount(Lotto.AMOUNT, passiveCount);
        LottoShuffleStrategy strategy = lottoNumbers -> {};

        // when
        LottoShop lottoShop = LottoShop.getInstance();
        List<Lotto> lottos = lottoShop.purchaseLotto(availablePurchaseCount, strategy);
        int actual = lottos.size();

        // then
        assertThat(actual).isEqualTo(1);
    }

}