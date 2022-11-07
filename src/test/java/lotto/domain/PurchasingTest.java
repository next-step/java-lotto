package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasingTest {

    @Test
    void 금액_로또_개수() {
        assertThat(new Purchasing(new Money("7200")).getLottoCnt()).isEqualTo(7);
        assertThat(new Purchasing(new Money("1001")).getLottoCnt()).isEqualTo(1);
        assertThat(new Purchasing(new Money("999")).getLottoCnt()).isEqualTo(0);
    }
}
