package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoStore;
import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoStoreTest {

    private LottoStore lottoStore;
    private Lotto[] lottos;

    @BeforeEach
    public void setUp() {
        lottoStore = new LottoStore();
        lottos = new Lotto[1];
        lottos[0] = new Lotto(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6));
    }

    @Test
    @DisplayName("로또 1장의 가격은 천원이다.")
    public void 로또_가격은_천원() {
        assertThat(lottoStore.price()).isEqualTo(new BigDecimal("1000"));
    }

    @Test
    @DisplayName("구매자가 낸 가격만큼 자동 로또를 발급한다. ex) 14000 / 1000 = 14장")
    public void 자동_로또_구입하기() {
        LottoBuyer lottoBuyer = new LottoBuyer(new BigDecimal("14000"));
        LottoList purchaseList = lottoStore.toSell(lottoBuyer.payMoney());
        assertThat(purchaseList.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("구매자가 낸 가격만큼 수동 로또를 발급한다.")
    public void 수동_로또_구입하기() {
        LottoBuyer lottoBuyer = new LottoBuyer(new BigDecimal("1000"));
        LottoList purchaseList = lottoStore.toSell(lottoBuyer.payMoney(), lottos);
        assertThat(purchaseList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("구매자가 낸 가격만큼 수동 또는 자동 로또를 발급한다.")
    public void 수동과_자동_로또_구입하기() {
        LottoBuyer lottoBuyer = new LottoBuyer(new BigDecimal("2000"));
        LottoList purchaseList = lottoStore.toSell(lottoBuyer.payMoney(), lottos);
        assertThat(purchaseList.size()).isEqualTo(2);
    }


    @Test
    @DisplayName("구입할 금액이 부족한 경우 오류")
    public void 구입할_금액_부족한_경우_오류내기() {
        assertThatThrownBy(() -> lottoStore.toSell(new BigDecimal("0"), lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액이 부족합니다.");
    }
}
