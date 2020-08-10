import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {14000, 17000, 20000, 1000, 500, 0})
    @DisplayName("입력받은 금액만큼 로또 게임을 생성한다.")
    void createLottoGameByMoneyTest(int inputMoney) {
        LottoMoney lottoMoney = new LottoMoney(inputMoney);
        List<LottoGame> lottoGames = lottoMoney.generateLottoGame();

        int expected = inputMoney / LottoMoney.MONEY_PER_GAME;
        assertThat(lottoGames.size()).isEqualTo(expected);
    }
}
