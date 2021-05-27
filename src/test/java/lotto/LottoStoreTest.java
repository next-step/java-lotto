package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoStore;
import lotto.domain.entity.LottoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    public void setUp() {
        lottoStore = new LottoStore();
    }

    @Test
    @DisplayName("로또 1장의 가격은 천원이다.")
    public void 로또_가격은_천원() {
        assertThat(lottoStore.price()).isEqualTo(new BigDecimal("1000"));
    }

    @Test
    @DisplayName("구매자가 낸 가격만큼 로또를 발급한다. ex) 14000 / 1000 = 14장")
    public void 로또_구입하기() {
        LottoBuyer lottoBuyer = new LottoBuyer(new BigDecimal("14000"));
        LottoList purchaseList = lottoStore.toSell(lottoBuyer.payMoney());
        assertThat(purchaseList.size()).isEqualTo(14);
    }
}
