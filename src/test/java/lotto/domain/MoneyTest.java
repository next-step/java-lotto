package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {

    private Money money;

    @BeforeEach
    void setUp() {
        this.money = new Money(10000);
    }

    @Test
    void 티켓_장수_계산() {
        Assertions.assertThat(money.countOfTickets(10)).isEqualTo(1000);
    }

    @Test
    void 수익률_계산() {
        Assertions.assertThat(money.rateOfReturn(10000)).isEqualTo(1);
    }

}
