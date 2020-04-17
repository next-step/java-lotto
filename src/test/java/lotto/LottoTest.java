package lotto;

import lotto.domain.LottoGame;
import lotto.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoGame lottoGame;


    @BeforeEach
    void setup() {
        lottoGame = new LottoGame();
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
            Result rank = lotto.match(winningLotto, bonus);
            results.add(rank);
        }
        assertThat(results.size()).isEqualTo(14);
    }


}
