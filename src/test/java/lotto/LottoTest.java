package lotto;

import lotto.domain.LottoGame;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private LottoGame lottoGame;


    @BeforeEach
    void setup() {
        lottoGame = new LottoGame();
    }

    @DisplayName("로또 구매 테스트")
    @Test
    void initLottos() {
        int money = 14000;
        Lottos lottos = lottoGame.initLottos(money);
        assertThat(lottos.getLottos().size()).isEqualTo(14);
    }

    @DisplayName("Match test")
    @Test
    void match() {
        int money = 14000;
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottos = lottoGame.initLottos(money);
        int bonus = 7;
        List<Result> results = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            Result rank = lotto.match(winningLotto, bonus, lotto);
            results.add(rank);
        }
        assertThat(results.size()).isEqualTo(14);
    }

    @DisplayName("lotto 랜덤 값이 1~45 사이인지 테스")
    @Test
    void randomLimit() {
        Lottos lottos = new Lottos();
        int random = lottos.getRandom();
        assertThat(random).isBetween(1, 45);
    }


    @DisplayName("lotto 생성 테스트")
    @Test
    void createLottos() {
        Lottos lottos = new Lottos(15);
        assertThat(lottos.getLottos().size()).isEqualTo(15);
    }


}
