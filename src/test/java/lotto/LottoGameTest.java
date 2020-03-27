package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다. (1000원=1게임)")
    @ParameterizedTest
    @CsvSource(value = {"3000, 3", "10000, 10"})
    public void buyLottoTest(int money, int expectedGameCount) {
        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.getGameCount()).isEqualTo(expectedGameCount);
    }

}
