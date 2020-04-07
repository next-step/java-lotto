package lotto;

import lotto.domain.LottoGame;
import lotto.model.Lotto;
import lotto.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Lotto> lottos = lottoGame.initLottos(money);
        assertThat(lottos.size()).isEqualTo(14);
    }

    @DisplayName("Match test")
    @Test
    void match() {
        int money = 14000;
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = lottoGame.initLottos(money);

        List<Result> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Result rank = lottoGame.match(winningLotto, lotto);
            results.add(rank);
        }
        assertThat(results.size()).isEqualTo(14);
    }

    @Test
    void buyCount() {
        int money = 14000;
        int count = lottoGame.purchaseLottoCount(money);
        assertThat(count).isEqualTo(14);
    }

    @DisplayName("lotto 랜덤 값이 1~45 사이인지 테스")
    @Test
    void randomLimit() {
        int random = lottoGame.getRandom();
        assertThat(random).isBetween(1, 45);
    }


    @DisplayName("lotto 생성 테스트")
    @Test
    void createLottos() {
        List<Lotto> lottos = lottoGame.createLottos(15);
        assertThat(lottos.size()).isEqualTo(15);
    }


}
