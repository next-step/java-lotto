package lotto.domain;

import lotto.dto.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @DisplayName("구입 금액에 해당하는 복권을 구매한다.")
    @Test
    void buy() {
        final Price price = new Price(14000);
        final int expect = 14;

        LotteryTickets actual = lotto.buy(price);

        assertThat(actual.count()).isEqualTo(14);
    }
}