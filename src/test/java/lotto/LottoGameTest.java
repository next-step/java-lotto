package lotto;

import lotto.domain.LottoGame;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
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

    @DisplayName("LottoGame mathces 1등 테스트")
    @Test
    void matches_1() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        Lottos myLotto = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));

        List<Result> results =lottoGame.matches(winningLotto, bonus, myLotto);
        assertThat(results.get(0).getRank()).isEqualTo(Rank.FIRST);
    }

    @DisplayName("LottoGame mathces 2등 테스트")
    @Test
    void matches_2() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        Lottos myLotto = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))));

        List<Result> results =lottoGame.matches(winningLotto, bonus, myLotto);
        assertThat(results.get(0).getRank()).isEqualTo(Rank.SECOND);
    }

    @DisplayName("LottoGame mathces 3등 테스트")
    @Test
    void matches_3() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        Lottos myLotto = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))));

        List<Result> results =lottoGame.matches(winningLotto, bonus, myLotto);
        assertThat(results.get(0).getRank()).isEqualTo(Rank.SECOND);
    }
}
