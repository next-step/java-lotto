package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGameTest {

    @DisplayName("구매 금액에 해당하는 갯수의 로또 발급")
    @CsvSource(value = {"1000, 1000, 1", "14000, 2000, 7", "5000, 5000, 1"})
    @ParameterizedTest
    void createLotto(int purchaseAmount, int lottoPrice, int expected) {
        // when
        LottoGame lottoGame = new LottoGame(purchaseAmount, lottoPrice);

        // then
        Assertions.assertThat(lottoGame.getLottoCount()).isEqualTo(expected);
    }

    @DisplayName("로또 구입 금액이 로또 1개 가격 단위가 아니거나 1개 가격 이하인 경우 IllegalArgumentException throw")
    @CsvSource(value={"0, 500", "500, 1000", "1500, 1000"})
    @ParameterizedTest
    void createLottoException(int purchaseAmount, int lottoPrice) {
        // when
        Assertions.assertThatThrownBy(() -> new LottoGame(purchaseAmount, lottoPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
