package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoBuyTest {

    @Test
    void 로또_구매() {
        LottoBuy lottoBuy = new LottoBuy(14000);

        Assertions.assertThat(lottoBuy.lottoBuyCountIsEqualTo(14)).isTrue();
    }
}
