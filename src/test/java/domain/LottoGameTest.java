package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGameTest {

    @DisplayName("구매 금액에 해당하는 갯수의 로또 발급")
    @CsvSource(value = {"1000, 1", "14000, 14", "5000, 5", "10000, 10"})
    @ParameterizedTest
    void createLotto(int purchaseAmount, int expected) {
        // when
        LottoGame lottoGame = new LottoGame(purchaseAmount);

        // then
        Assertions.assertThat(lottoGame.getLottoCount()).isEqualTo(expected);
    }
}
