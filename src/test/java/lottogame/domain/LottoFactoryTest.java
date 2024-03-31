package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @Test
    void 구입금액에_따른_로또갯수를_생성() {
        Money money = Money.from(10_000);
        Money price = Money.from(1_000);
        int expected = 10;

        assertThat(LottoFactory.createMultipleLottos(Number.from(money.divide(price).toInt())).size()).isEqualTo(expected);
    }

    @Test
    void 구입금액에_따른_로또갯수를_계산하기() {
        Money money = Money.from(10_000);
        Money price = Money.from(1_000);
        Number expected = Number.from(10);
        Number countOfLottos = LottoFactory.calculateCountOfLottos(money, price);

        assertThat(countOfLottos).isEqualTo(expected);
    }
}