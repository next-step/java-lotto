package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @Test
    void sell() {
        assertThat(new LottoShop().sell(14000)).isEqualTo(14);
    }
}
