package lotto;

import lotto.exception.MoneyNotEnoughException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    @ParameterizedTest
    @ValueSource(ints = {900, 100, 250, 10, 400})
    @DisplayName("buy lotto test : fail")
    void buyLottoTest(int money) {
        LottoGame lottoGame = new LottoGame();
        assertThatThrownBy(() -> lottoGame.buyLotto(money))
                .isInstanceOf(MoneyNotEnoughException.class)
                .hasMessage("Money is not enough to buy lotto");
    }

    @ParameterizedTest
    @ValueSource(ints = {9000, 1000, 25000, 4000})
    @DisplayName("buy lotto test : success")
    void buyLottoFailTest(int money) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.buyLotto(money);
        assertThat(lottoGame.getLottos().size()).isEqualTo(money/1000);
    }
}