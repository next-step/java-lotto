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

        final List<LottoNumber> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        final LottoNumber bonusBall = new LottoNumber(8);

        final WinningLotto winningLotto = new WinningLotto(Lotto.handOperatedLotto(winningNumber), bonusBall);

        lottoGame = new LottoGame(lottos, winningLotto);
    }

    private Lotto createLotto(final List<Integer> numbers) {
        return
            Lotto.handOperatedLotto(numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    @Test
    void 내부에_모든_로또를_저장할_수_있다() {
        final Lottos lottos = lottoGame.getLottos();

        assertThat(lottos.getLottos().size()).isEqualTo(4);
    }

    @Test
    void 발급한_모든_로또의_결과를_알_수_있다() {
        final LottoResults lottoResults = lottoGame.findWinner();
        final Map<Ranking, Integer> totalResult = lottoResults.getTotalResult();

        assertAll(
            () -> assertThat(totalResult).containsEntry(Ranking.FIRST, 1),
            () -> assertThat(totalResult).containsEntry(Ranking.SECOND, 1),
            () -> assertThat(totalResult).containsEntry(Ranking.THIRD, 0),
            () -> assertThat(totalResult).containsEntry(Ranking.FIFTH, 1),
            () -> assertThat(totalResult).containsEntry(Ranking.FIFTH, 1)
        );
    }

    @Test
    void 수익률을_계산할_수_있다() {
        final LottoResults lottoResults = lottoGame.findWinner();

        final BigDecimal yield = lottoResults.calculateYield(new Money(5000));

        assertThat(yield).isEqualTo(BigDecimal.valueOf(40601100, 2));
    }
}
