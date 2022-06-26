package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {

    @Test
    @DisplayName("로또_가격은_1000원이다.")
    void lottoPrice() {
        assertThat(LottoStore.purchaseLotto(1000)).hasSize(1);
        assertThat(LottoStore.purchaseLotto(1500)).hasSize(1);
        assertThat(LottoStore.purchaseLotto(4000)).hasSize(4);
    }

    @Test
    @DisplayName("1000원_미만으로_로또_구매_불가")
    void invalidLottoPrice() {
        assertThatThrownBy(() -> {
            LottoStore.purchaseLotto(500);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(LottoStore.INVALID_PURCHASE_MONEY_MESSAGE);
    }

}