package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {
    @Test
    void create() {
        LottoPurChase lottoPurChase = new LottoPurChase(14000, 11, 3);

        Assertions.assertThat(lottoPurChase.getMoney()).isEqualTo(new Money(14000));
    }
}
