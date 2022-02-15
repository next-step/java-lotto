package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        List<Lotto> lottos = new ArrayList<>();
        final List<LottoNumber> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        final List<LottoNumber> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 5, 7).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        lottos.add(new Lotto(lottoNumbers1));
        lottos.add(new Lotto(lottoNumbers2));

        Lottos userLottos = new Lottos(lottos);

        WinningLotto winningLotto = new WinningLotto(new Lotto(lottoNumbers1), new LottoNumber(8));

        lottoGame = new LottoGame(userLottos, winningLotto);
    }

    @Test
    void 수익률을_계산할_수_있다() {
        LottoResults lottoResults = lottoGame.findWinner();

        final BigDecimal yield = lottoResults.calculateYield(new Money(10000));

        assertThat(yield).isEqualTo(BigDecimal.valueOf(20015000, 2));
    }
}
