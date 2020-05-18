package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    @DisplayName("구입금액이 1000원 미만이면 LottoGame을 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = { 100, 200, 500, 900, 999 })
    void canNotCreateLottoGameIfPurchaseAmountGreaterThan1000(int purchaseAmount) {
        assertThatThrownBy(() -> new LottoGame(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 이상이면 LottoGame을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = { 1000, 2000, 5000, 9000 })
    void canCreateLottoGameIfPurchaseAmount1000OrMore(int purchaseAmount) {
        assertThat(new LottoGame(purchaseAmount)).isNotNull();
    }

    @DisplayName("구입금액에 대한 구입수량을 구할 수 있다.")
    @Test
    void canGetPurchaseCountByLottoGame() {
        LottoGame lottoGame = new LottoGame(14000);
        assertThat(lottoGame.getPurchaseCount()).isEqualTo(14);
    }
}
