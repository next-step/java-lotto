package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    private LottoGame lottoGame;
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(new ArrayList<>());

        lottos.storeLotto(createLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.storeLotto(createLotto(Arrays.asList(1, 2, 3, 4, 8, 6)));
        lottos.storeLotto(createLotto(Arrays.asList(1, 2, 3, 4, 7, 10)));
        lottos.storeLotto(createLotto(Arrays.asList(1, 2, 3, 7, 10, 9)));

        List<LottoNumber> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        LottoNumber bonusBall = new LottoNumber(8);

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumber), bonusBall);

        lottoGame = new LottoGame(lottos, winningLotto);
    }

    private Lotto createLotto(final List<Integer> numbers) {
        return new
            Lotto(numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    @Test
    void 내부에_모든_로또를_저장할_수_있다() {
        Lottos lottos = lottoGame.getLottos();

        assertThat(lottos.getLottos().size()).isEqualTo(4);
    }

    @Test
    void 발급한_모든_로또의_결과를_알_수_있다() {
        Map<Ranking, Integer> totalResult = lottoGame.findWinner();

        assertAll(
            () -> assertThat(totalResult.get(Ranking.FIRST)).isEqualTo(1),
            () -> assertThat(totalResult.get(Ranking.SECOND)).isEqualTo(1),
            () -> assertThat(totalResult.get(Ranking.THIRD)).isEqualTo(0),
            () -> assertThat(totalResult.get(Ranking.FOURTH)).isEqualTo(1),
            () -> assertThat(totalResult.get(Ranking.FIFTH)).isEqualTo(1)
        );
    }

    @Test
    void 수익률을_계산할_수_있다() {
        Map<Ranking, Integer> totalResult = lottoGame.findWinner();

        BigDecimal yield = lottoGame.calculateYield(totalResult, new Money(5000));

        assertThat(yield).isEqualTo(BigDecimal.valueOf(406011));
    }
}
