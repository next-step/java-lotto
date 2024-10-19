package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    private Lottos lottos;
    private Lotto lastWinningLotto;

    private LottoResults lottoResults;

    @BeforeEach
    void createLottos() {
        lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))));
    }

    @BeforeEach
    void createLastWinningLotto() {
        lastWinningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @BeforeEach
    void createLottoResults() {
        Map<LottoRankEnum, Integer> results = new HashMap<>();
        results.put(LottoRankEnum.FIFTH, 1);
        results.put(LottoRankEnum.FOURTH, 0);
        results.put(LottoRankEnum.THIRD, 0);
        results.put(LottoRankEnum.FIRST, 1);
        lottoResults = new LottoResults(results);
    }

    @Test
    void 로또_결과() {
        assertThat(lottos.getResults(lastWinningLotto)).isEqualTo(lottoResults);
    }
}