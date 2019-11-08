package lotto.domain2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {

    @Test
    void 생성() {
        Store store = new Store(new LottoMachine());
        assertThat(store).isEqualTo(new Store(new LottoMachine()));
    }
}
