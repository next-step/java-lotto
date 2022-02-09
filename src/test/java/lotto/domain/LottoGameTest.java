package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    LottoGame lottoGame;
    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
        lottos = new Lottos();

        lottos.storeLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList())));

        lottos.storeLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList())));

        lottos.storeLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 10).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList())));

        lottos.storeLotto(new Lotto(Arrays.asList(1, 2, 3, 7, 10, 9).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList())));
    }

    @Test
    void 투입한_금액만큼_로또를_살_수_있다() {
        Lottos lottos = lottoGame.startLotto(2000, LottoShop.getInstance());

        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

    @Test
    void 발급한_모든_로또의_결과를_알_수_있다() {
        List<LottoNumber> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        LottoNumber bonusBall = new LottoNumber(8);

        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusBall);

        Map<Ranking, Integer> totalResult = lottoGame.findWinner(winningLotto, lottos);

        assertAll(
            () -> assertThat(totalResult.get(Ranking.FIRST)).isEqualTo(1),
            () -> assertThat(totalResult.get(Ranking.SECOND)).isEqualTo(1),
            () -> assertThat(totalResult.get(Ranking.THIRD)).isEqualTo(0),
            () -> assertThat(totalResult.get(Ranking.FOURTH)).isEqualTo(1),
            () -> assertThat(totalResult.get(Ranking.FOURTH)).isEqualTo(1)
        );

    }
}
