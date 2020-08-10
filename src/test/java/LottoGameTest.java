import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class LottoGameTest {

    @RepeatedTest(100)
    @DisplayName("로또 한 게임 생성 : 1~45 사이의 6개의 숫자를 랜덤으로 생성한다.")
    void createGameTest() {
        LottoGame lottoGame = new LottoGame(RandomGenerator.getSixRandomNumber());
        LottoGame lottoGame1 = new LottoGame(RandomGenerator.getSixRandomNumber());

        assertThat(lottoGame).isNotEqualTo(lottoGame1);
        System.out.println(lottoGame);
        System.out.println(lottoGame1);
    }
}
