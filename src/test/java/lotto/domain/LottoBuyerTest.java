package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoBuyerTest {

    @Test
    void buyLottos() {
        LottoBuyer buyer = new LottoBuyer(new StubStore());
        Lottos lottos = buyer.buyLottos(new Money(4_000));

        assertThat(lottos.size()).isEqualTo(4);
    }

    @Test
    void checkWinning() {
        LottoBuyer buyer = new LottoBuyer(new StubStore());
        Lottos lottos = buyer.buyLottos(new Money(4_000L));
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        Matchs matchs = buyer.checkWinning(winningLotto);

        assertThat(matchs).isEqualTo(MatchsTest.getMatchs());
    }

    private static class StubStore implements Store {
        @Override
        public Lottos sell(Money buyAmount) {
            return LottosTest.getLottos();
        }
    }
}