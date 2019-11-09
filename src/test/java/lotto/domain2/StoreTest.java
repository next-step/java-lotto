package lotto.domain2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StoreTest {

    @Test
    void 생성() {
        Store store = new Store(new BasicLottoMachine());
        assertThat(store).isEqualTo(new Store(new BasicLottoMachine()));
    }

    @ParameterizedTest
    @ValueSource(ints = 1000)
    void 로또발급(final int money) {
        Store store = new Store(new BasicLottoMachine());
        Lottos lottos = store.issueLotto(money, Collections.emptyList());
        assertThat(lottos.count()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = 999)
    void 로또발급_구매가격미달(final int money) {
        Store store = new Store(new BasicLottoMachine());
        assertThatThrownBy(() -> {
            store.issueLotto(money, Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = 2_000)
    void 수동로또발급(final int money) {
        Store store = new Store(new BasicLottoMachine());
        List<String> directLottos = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");
        Lottos lottos = store.issueLotto(money, directLottos);
        assertThat(lottos.findCountOfDirectLottos()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(ints = 1_000)
    void 수동로또_구매_돈_부족(final int money) {
        Store store = new Store(new BasicLottoMachine());
        List<String> directLottos = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");
        assertThatThrownBy(() -> {
            store.issueLotto(money, directLottos);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
