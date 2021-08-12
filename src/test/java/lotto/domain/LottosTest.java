package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    Lottos lottos = new Lottos();

    @DisplayName("금액 만큼 로또 생성(1000원에 로또 1개)")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "3000:3", "4000:4"}, delimiter = ':')
    void createLottoList_happyCase(int cash, int excepted) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(cash);
        lottos.create(purchaseAmount);
        assertThat(lottos.count()).isEqualTo(excepted);
    }

    @DisplayName("금액 만큼 로또 생성(1000원에 로또 1개)")
    @ParameterizedTest
    @ValueSource(ints = {0, 1500, 2500, 999})
    void createLottoList_blueCase(int cash) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(cash);
        assertThatThrownBy(() -> lottos.create(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
