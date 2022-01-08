package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    private LottoResult lottoResult;

    private static final List<Integer> matchCounts =
        new ArrayList<>(Arrays.asList(1, 1, 2, 4, 5, 6));

    @Test
    void setUp() {
        List<Boolean> matchBonusBall =
            new ArrayList<>(Arrays.asList(true, false, false, false, true, false));

        List<MatchResult> matchResult = new ArrayList<>();
        for (int i = 0; i < matchCounts.size(); i++) {
            matchResult.add(new MatchResult(matchCounts.get(i), matchBonusBall.get(i)));
        }
        lottoResult = new LottoResult(matchResult);
    }

    @Test
    @DisplayName("주어진 맞춤 번호와 같은 로또번호의 갯수 리스트로 동일한 갯수의 수를 맞춘 로또의 수 결과를 올바르게 반환한다.")
    void create_lotto_game() {
        //given
        setUp();

        //when
        Map<MatchType, Integer> matchResult = lottoResult.getResult();

        //then
        assertEquals(matchResult.get(MatchType.THREE), Collections.frequency(matchCounts, 3));
        assertEquals(matchResult.get(MatchType.FOUR), Collections.frequency(matchCounts, 4));
        assertEquals(matchResult.get(MatchType.FIVE), Collections.frequency(matchCounts, 5) - 1);
        assertEquals(matchResult.get(MatchType.FIVE_AND_BONUS_BALL),
            Collections.frequency(matchCounts, 5));
        assertEquals(matchResult.get(MatchType.SIX), Collections.frequency(matchCounts, 6));
    }

    @ParameterizedTest
    @MethodSource("lottoResults")
    @DisplayName("올바른 수익률을 반환한다.")
    void get_yield(LottoResult lottoResult, BigDecimal expected) {
        //given

        //when
        BigDecimal yield = lottoResult.getYield();

        //then
        assertTrue(yield.equals(yield));
    }

    private static Stream<Arguments> lottoResults() {
        return Stream.of(
            Arguments.of(new LottoResult(new ArrayList<MatchResult>() {{
                    add(new MatchResult(1, true));
                    add(new MatchResult(3, false));
                    add(new MatchResult(5, true));
                    add(new MatchResult(6, false));
                }})
                , new BigDecimal(507501.25)),
            Arguments.of(new LottoResult(new ArrayList<MatchResult>() {{
                    add(new MatchResult(1, true));
                    add(new MatchResult(2, true));
                    add(new MatchResult(4, true));
                    add(new MatchResult(6, false));
                }})
                , new BigDecimal(500012.50)),
            Arguments.of(new LottoResult(new ArrayList<MatchResult>() {{
                    add(new MatchResult(1, true));
                    add(new MatchResult(3, false));
                    add(new MatchResult(5, true));
                    add(new MatchResult(5, false));
                    add(new MatchResult(6, false));
                }})
                , new BigDecimal(406301.00))
        );
    }

}