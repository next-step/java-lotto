import domain.LottoNumbers;
import domain.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @RepeatedTest(100)
    @DisplayName("로또 한 게임 생성 : 1~45 사이의 6개의 숫자를 랜덤으로 생성한다.")
    void createGameTest() {
        LottoNumbers lottoGame = new LottoNumbers(RandomGenerator.getSixRandomNumber());
        LottoNumbers lottoGame1 = new LottoNumbers(RandomGenerator.getSixRandomNumber());

        assertThat(lottoGame).isNotEqualTo(lottoGame1);
        System.out.println(lottoGame);
        System.out.println(lottoGame1);
    }
}
