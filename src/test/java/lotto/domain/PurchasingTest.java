package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasingTest {

    @Test
    void 금액_로또_개수() {
        assertThat(new Purchasing(10000).getLottoCnt()).isEqualTo(10);
        assertThat(new Purchasing(900).getLottoCnt()).isEqualTo(0);
    }
}