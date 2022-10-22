package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StoreTest {

    @Test
    void 로또_구매() {
        Assertions.assertThat(new Store(new Money(15000)).getLottoTickets()).hasSize(15);
    }

}
