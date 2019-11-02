package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {

    @Test
    void 로또발급() {
        Store store = new Store(new BasicLottoMachine(new BasicNumberGenerator()));
        IssuedLottos issuedLottos = store.issueLottos(14000);
        assertThat(issuedLottos.count()).isEqualTo(14);
    }
}
