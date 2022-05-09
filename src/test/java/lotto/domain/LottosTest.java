package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static lotto.domain.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("strategy를 입력받아 로또를 생성한다.")
    @Test
    void generateLottosFromStrategyTest() {
        Lottos lottos = new Lottos();
        assertThat(lottos.generateLottosFromStrategy(new RandomNumberGenerator(), 3))
                .isEqualTo(3);
    }

    @DisplayName("유저 Input으로부터 로또를 생성한다..")
    @Test
    void generateLottoFromUserInputTest() {
        Lottos lottos = new Lottos();
        assertThat(lottos.generateLottoFromUserInput("1,2,3,4,5,6"))
                .isEqualTo(1);
    }

    @DisplayName("당첨 번호와 보너스 번호를 입력하면, 각 당첨별 개수를 담은 Map을 반환한다.")
    @Test
    void countWinningLottoTest() {
        Lottos lottos = new Lottos();
        lottos.generateLottoFromUserInput("1,2,3,4,5,6");
        lottos.generateLottoFromUserInput("1,2,3,4,5,7");
        lottos.generateLottoFromUserInput("1,2,3,4,7,8");
        Map<Ranking, Integer> rankingMap = lottos.countWinningLotto(new Lotto("1,2,3,4,5,6"), LottoNumber.createNewNumber(7));

        assertThat(rankingMap.get(FIRST)).isEqualTo(1);
        assertThat(rankingMap.get(SECOND)).isEqualTo(1);
        assertThat(rankingMap.get(FOURTH)).isEqualTo(1);
    }
}
