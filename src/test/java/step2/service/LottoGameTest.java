package step2.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @ParameterizedTest(name = "로또 구매 장 수만큼 게임이 진행되는지 테스트")
    @CsvSource(value = {"1|1", "2|2", "3|3"}, delimiter = '|')
    void executeGame(int numOfLottoTicket, int expected) {
        LottoGame lottoGame = new LottoGame(numOfLottoTicket);
        assertThat(lottoGame.executeGame()).hasSize(expected);
    }
}
