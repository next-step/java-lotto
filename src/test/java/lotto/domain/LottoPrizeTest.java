package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @Test
    void 수량으로_금액을_계산_할_수_있다() {
        LottoPrize prize = new LottoPrize(1000, Currency.KRW);

        long actual = prize.calculateAmount(2);
        long expected = 2000;

        assertThat(actual).isEqualTo(expected);
    }

}
