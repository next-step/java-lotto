package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;

    private static final List<Integer> matchCounts =
        new ArrayList<>(Arrays.asList(1, 1, 2, 4, 5, 6));
    private static final float CONSUME_PRICE = 6000f;

    void setUp() {
        lottoResult = new LottoResult(matchCounts);
    }

    @Test
    @DisplayName("주어진 맞춤 번호와 같은 로또번호의 갯수 리스트로 동일한 갯수의 수를 맞춘 로또의 수 결과를 올바르게 반환한다.")
    void create_lotto_game() {
        //given
        setUp();

        //when
        Map<MatchType, Integer> matchResult = lottoResult.getMatchResult();

        //then
        assertEquals(matchResult.get(MatchType.THREE), Collections.frequency(matchCounts, 3));
        assertEquals(matchResult.get(MatchType.FOUR), Collections.frequency(matchCounts, 4));
        assertEquals(matchResult.get(MatchType.FIVE), Collections.frequency(matchCounts, 5));
        assertEquals(matchResult.get(MatchType.SIX), Collections.frequency(matchCounts, 6));
    }

    @Test
    @DisplayName("올바른 수익률을 반환한다.")
    void get_yield() {
        //given
        setUp();

        //when
        float yield = lottoResult.getYield();
        Map<MatchType, Integer> matchResult = lottoResult.getMatchResult();
        int total = 0;
        for (Map.Entry<MatchType, Integer> entry : matchResult.entrySet()) {
            total += (entry.getKey().getMoney() * entry.getValue());
        }

        //then
        assertEquals(yield, total / CONSUME_PRICE);
    }


}