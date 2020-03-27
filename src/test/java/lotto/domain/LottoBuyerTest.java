package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBuyerTest {
    @Test
    void getCount() {
        LottoBuyer lottoBuyer = new LottoBuyer(15000);

        assertThat(lottoBuyer.getCount()).isEqualTo(15);
    }
}
