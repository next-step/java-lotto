package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName("")
    void buyLotto() {
        LottoStore store = LottoStore.getInstance();

        assertThat(store.buyLotto(new Money(14000))).isEqualTo(14);
    }
}
