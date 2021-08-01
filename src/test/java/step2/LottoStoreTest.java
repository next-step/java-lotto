package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    @Test
    @DisplayName("예산에따라 로또의 갯수를 구하는 테스트")
    void getLottoQuantityByBudgetTest() {
        assertThat(LottoStore.getAvailableQuantityByBudget(14000)).isEqualTo(14);

        assertThat(LottoStore.getAvailableQuantityByBudget(900)).isEqualTo(0);
    }
}
