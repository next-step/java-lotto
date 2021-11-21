package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {
    @Test
    @DisplayName("로또 생성")
    void ticket() {
        Lotto lotto = LottoStore.ticket(14000);
        assertThat(lotto.getLotto()).hasSize(14);
    }
}