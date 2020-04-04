package lotto;

import lotto.domain.LottoGame;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto winningLotto;
    private Lotto myLotto;

    private LottoGame lottoGame;


    @BeforeEach
    void setup() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoGame = new LottoGame();
    }


    @Test
    void initLottos() {
    }

    @Test
    void match() {
        int rank = lottoGame.match(winningLotto, myLotto);

        assertThat(rank).isEqualTo(1);
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
