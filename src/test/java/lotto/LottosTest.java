package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void buyLotto() {
        // given
        Money money = new Money(10000);

        // when
        Lottos lottos = Lottos.buy(money);

        // then
        assertThat(lottos.getLottos()).isNotEmpty();
    }

    @Test
    void buyLotto_count() {
        // given
        Money money = new Money(100000);

        // when
        Lottos lottos = Lottos.buy(money);

        // then
        assertThat(lottos.count()).isEqualTo(100);
    }
}