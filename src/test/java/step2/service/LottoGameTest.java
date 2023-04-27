package step2.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1|1", "2|2", "3|3"}, delimiter = '|')
    void executeGame(int numOfLottoTicket, int expected) {
        LottoGame lottoGame = new LottoGame(numOfLottoTicket);
        assertThat(lottoGame.executeGame()).hasSize(expected);
    }
}
