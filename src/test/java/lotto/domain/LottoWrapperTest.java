package lotto.domain;

import lotto.enumerate.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWrapperTest {
    private static final int NO_MATCH_NUMBER = -1;
    private static final int BONUS_NUMBER = 0;
    private static LottoNumbersWrapper collectNumbers = new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static Map<Rank, Lotto> lottoEnumMap = new EnumMap(Rank.class);

    @BeforeAll
    static void setLottoEnumMap() {
        lottoEnumMap.put(Rank.FIRST, new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoEnumMap.put(Rank.SECOND, new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, BONUS_NUMBER))));
        lottoEnumMap.put(Rank.THIRD, new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, NO_MATCH_NUMBER))));
        lottoEnumMap.put(Rank.FOURTH, new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, NO_MATCH_NUMBER, NO_MATCH_NUMBER))));
        lottoEnumMap.put(Rank.FIFTH, new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, NO_MATCH_NUMBER, NO_MATCH_NUMBER, NO_MATCH_NUMBER))));
    }

    @ParameterizedTest
    @DisplayName("1 ~ 5등 단일 당첨 Rank 조회 테스트")
    @EnumSource
    void getResultRanksTest(Rank rank) {
        LottoWrapper lottoWrapper = new LottoWrapper(Arrays.asList(lottoEnumMap.get(rank)));
        List<Rank> resultRanks = lottoWrapper.getResultRanks(collectNumbers, BONUS_NUMBER);

        assertThat(resultRanks).hasSize(1);
        assertThat(resultRanks.get(0)).isEqualTo(rank);
    }

    @Test
    @DisplayName("1 ~ 5등 동시 당첨 Rank 조회 테스트")
    void getResultRanksTest2() {
        List<Lotto> winLottos = new ArrayList<>(lottoEnumMap.values());
        LottoWrapper lottoWrapper = new LottoWrapper(winLottos);
        List<Rank> resultRanks = lottoWrapper.getResultRanks(collectNumbers, BONUS_NUMBER);

        assertThat(resultRanks).hasSize(winLottos.size());
    }
}