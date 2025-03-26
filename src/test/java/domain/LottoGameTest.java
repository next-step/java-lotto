package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("로또 구입 금액이 1000원 단위가 아니거나 0원 이하인 경우 IllegalArgumentException throw")
    @CsvSource(value = {"0", "500", "1500", "999"})
    @ParameterizedTest
    void createLottoException(int purchaseAmount) {
        // when
        Assertions.assertThatThrownBy(() -> new LottoGame(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 0원 이상이어야 하며 1000원 단위로 가능합니다.");
    }
}
