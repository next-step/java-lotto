package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoGameTest {


    // init with 1000 ~
    @DisplayName("금액별 구매 매수 체크")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "5500:5", "12200:12"}, delimiter = ':')
    public void testCalculateGameCountByPayMoney(String input, int count) {
        Money money = new Money(input);
        LottoGame lottoGame = new LottoGame(money);
        assertThat(lottoGame.getLottoTickets().getLottoTicketsSize()).isEqualTo(count);
    }


    // init with under 1000 ~
    @DisplayName("부족 금액 입력 체크")
    @ParameterizedTest
    @ValueSource(strings = {"0", "100", " 900"})
    public void testCalculateGameCountByPayMoneyWithError(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoGame(new Money(input));
                });
    }


    @DisplayName("init Class with negative input")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-1"})
    public void testCalculateGameCountByPayMoneyWithNegativeInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Money money = new Money(input);
                    LottoGame lottoGame = new LottoGame(money);
                });
    }

}
