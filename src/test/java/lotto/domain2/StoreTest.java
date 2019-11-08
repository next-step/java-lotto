package lotto.domain2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StoreTest {

    @Test
    void 생성() {
        Store store = new Store(new LottoMachine());
        assertThat(store).isEqualTo(new Store(new LottoMachine()));
    }

    @ParameterizedTest
    @ValueSource(ints = 1000)
    void 로또발급(final int money) {
        Store store = new Store(new LottoMachine());
        Lottos lottos = store.issueLotto(money);
        assertThat(lottos.count()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = 999)
    void 로또발급_구매가격미달(final int money) {
        Store store = new Store(new LottoMachine());
        assertThatThrownBy(() -> {
            store.issueLotto(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
