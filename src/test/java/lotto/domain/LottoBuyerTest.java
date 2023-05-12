package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoBuyerTest {

    @Test
    void buyLottos() {
        LottoBuyer buyer = new LottoBuyer(new StubStore());
        Lottos lottos = buyer.buyLottos(new Money(5_000));

        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    void checkWinning() {
        LottoBuyer buyer = new LottoBuyer(new StubStore());
        Lottos lottos = buyer.buyLottos(new Money(5_000L));
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        RankResult rankResult = buyer.checkWinning(new WinningLotto(winningLotto, new LottoNumber(7)));

        assertThat(rankResult).isEqualTo(RankResultTest.getRankResult());
    }

    private static class StubStore implements Store {
        @Override
        public Lottos sell(Money buyAmount) {
            return LottosTest.getLottos();
        }
    }
}