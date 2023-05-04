package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoBuyerTest {

    @Test
    void receive() {
        LottoBuyer buyer = new LottoBuyer();
        Lottos lottos = LottosTest.getLottos();
        buyer.receive(lottos);

        assertThat(buyer).isEqualTo(new LottoBuyer(lottos, 0L, 4_000L));
    }

    @Test
    void checkWinning() {
        LottoBuyer buyer = new LottoBuyer(LottosTest.getLottos());
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        Matchs matchs = buyer.checkWinning(winningLotto);

        assertThat(matchs).isEqualTo(MatchsTest.getMatchs());
    }

    @Test
    void earn() {
        LottoBuyer buyer = new LottoBuyer();
        buyer.earn(new Money(1_000L));

        assertThat(buyer).isEqualTo(new LottoBuyer(1_000L, 0));
    }

    @Test
    @DisplayName("수익률을 계산해서 반환한다.")
    void calculateRateOfEarning() {
        LottoBuyer buyer = new LottoBuyer(100L, 2L);

        assertThat(buyer.calculateRateOfEarning()).isEqualTo(50);
    }
}