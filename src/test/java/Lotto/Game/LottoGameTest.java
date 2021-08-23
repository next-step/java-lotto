package Lotto.Game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 게임은")
public class LottoGameTest {

    @DisplayName("지불액이")
    @ParameterizedTest(name = "{0}원일 경우: {1}장의 로또 티켓을 만든다.")
    @CsvSource(value = {"14000:14", "15000:15"}, delimiter = ':')
    void create(int payments, int totalNumberOfTickets) {
        LottoGame lottoGame = new LottoGame(payments);
        assertThat(lottoGame.getLottoTickets().size()).isEqualTo(totalNumberOfTickets);
    }
}
