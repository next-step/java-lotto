package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class LottoBuyerTest {

    @Test
    @DisplayName("10000원만큼 구매하면 소비금액은 10000원이 된다.")
    void buy() {
        LottoBuyer buyer = new LottoBuyer();
        ByteArrayInputStream input = new ByteArrayInputStream("10000".getBytes());
        System.setIn(input);

        buyer.buy();

        assertThat(buyer).isEqualTo(new LottoBuyer(0L, 10_000L));
    }

    @Test
    void receive() {
        LottoBuyer buyer = new LottoBuyer();
        Lottos lottos = LottosTest.getLottos();
        buyer.receive(lottos);

        assertThat(buyer).isEqualTo(new LottoBuyer(lottos));
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