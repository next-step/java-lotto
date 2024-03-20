package lottoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName("구매 비용은 1000의 배수여야 합니다. 아닐 시 IllegalArgumentException")
    void INPUT_MULTIPLIES_OF_1000() {
        assertThat(LottoStore.sellLotto(14000)).isEqualTo(14);

        assertThatThrownBy(() -> LottoStore.sellLotto(13500))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 비용은 음수가 올 수 없습니다.")
    void INPUT_MINUS_MONEY_THEN_EXCEPTION() {
        assertThatThrownBy(() -> LottoStore.sellLotto(-1000))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
