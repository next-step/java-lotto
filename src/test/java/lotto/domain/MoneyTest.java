package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by wyparks2@gmail.com on 2019-07-08
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class MoneyTest {

    @Test
    void 구매가능_로또_조회() {
        Money money = new Money(14000);

        assertThat(money.canBuyLottoCount()).isEqualTo(14);
    }

    @Test
    void 구매금액_0원_보다_작거나_같을때_오류발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(0));
    }
}
