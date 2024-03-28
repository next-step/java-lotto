package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @Test
    void 구입금액에_따른_로또갯수를_생성() {
        Money money = Money.from(10_000);
        Money price = Money.from(1_000);
        int expected = 10;

        assertThat(LottoFactory.createLottoses(money, price).size()).isEqualTo(expected);
    }
}