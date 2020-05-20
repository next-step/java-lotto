package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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
    @ParameterizedTest
    @CsvSource(value = { "14000,14", "5600,5" })
    void canGetPurchaseCountByLottoGame(int amount, int result) {
        LottoGame lottoGame = new LottoGame(amount);
        assertThat(lottoGame.getPurchaseCount()).isEqualTo(result);
    }

    @DisplayName("구입수량에 맞게 로또 번호를 생성할 수 있다.")
    @Test
    void canCreateLottoNumbers() {
        LottoGame lottoGame = new LottoGame(14000);
        List<LottoNumbers> lottoNumbers = lottoGame.createLottoNumbers();

        assertThat(lottoNumbers).isNotNull();
        assertThat(lottoNumbers).hasSize(14);
    }
}
