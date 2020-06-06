package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoGameTest {


    // init with 1000 ~
    @DisplayName("금액별 구매 매수 체크")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1000:1", "2000:2", "5000:5", "10000:10"}, delimiter = ':')
    public void testCalculateGameCountByPayMoney(String input, int count) {

        Money money = new Money(input);
        LottoGame lottoGame = new LottoGame();
        int gameCount = lottoGame.calculateGameCountByPayMoney(money);

        assertThat(gameCount).isEqualTo(count);

    }


    // init with 1000 ~
    @DisplayName("금액별 구매 매수 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1100", "100", "1400", "5400", "10001"})
    public void testCalculateGameCountByPayMoneyWithError(String input) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Money money = new Money(input);
                    LottoGame lottoGame = new LottoGame();
                    lottoGame.calculateGameCountByPayMoney(money);
                });

    }


    @DisplayName("init Class with negative input")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-1"})
    public void testCalculateGameCountByPayMoneyWithNegativeInput(String input) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoGame lottoGame = new LottoGame();
                    Money money = new Money(input);
                    lottoGame.calculateGameCountByPayMoney(money);
                });

    }


    // init with null, emtpy
    @DisplayName("init Class")
    @ParameterizedTest
    @NullAndEmptySource
    public void testClassInitialize(String input) {

        LottoGame lottoGame = new LottoGame();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Money money = new Money(input);
                    lottoGame.calculateGameCountByPayMoney(money);
                });

    }


    @DisplayName("test get Game Count length error")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5:6", "1,2,3,4,5,6,7:8"}, delimiter = ':')
    public void testCheckWiningNumber(String input, String bonusNumber) {

        LottoGame lottoGame = new LottoGame();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoGame.checkWiningNumber(input, bonusNumber));
    }


}
