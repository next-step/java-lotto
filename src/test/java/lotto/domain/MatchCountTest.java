package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MatchCountTest {

    @DisplayName("매치결과 확인 - 5개일치, 보너스 포함")
    void getResult_five_bonus() {
        //when, then
        assertThat(MatchCount.getResult(5, true)).isEqualTo(MatchCount.SECOND_WITH_BONUS);
    }

    @DisplayName("매치결과 확인 - 5개일치, 보너스 포함")
    void getResult_five() {
        //when, then
        assertThat(MatchCount.getResult(5, false)).isEqualTo(MatchCount.SECOND);
    }

    @DisplayName("매치결과 확인 - 3,4,6개")
    @Test
    void getResult_other() {
        //when, then
        assertThat(MatchCount.getResult(3, false)).isEqualTo(MatchCount.FORTH);
        assertThat(MatchCount.getResult(4, false)).isEqualTo(MatchCount.THIRD);
        assertThat(MatchCount.getResult(6, false)).isEqualTo(MatchCount.FIRST);
    }

    @DisplayName("매치결과 확인 - 3개 미만")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void getResult_miss(int matchCount) {
        //when, then
        assertThat(MatchCount.getResult(matchCount, true)).isEqualTo(MatchCount.MISS);
    }

    @DisplayName("당첨결과 map 생성")
    @Test
    void matchResult() {
        //given
        Map<MatchCount, Integer> matchCounts = new HashMap<MatchCount, Integer>() {{
            put(MatchCount.FIRST, 1);
            put(MatchCount.THIRD, 3);
        }};

        //when
        Map<MatchCount, Integer> matchResults = MatchCount.result(matchCounts);

        //then
        assertThat(matchResults.size()).isEqualTo(MatchCount.values().length - 1);
        assertThat(matchResults.get(MatchCount.FIRST)).isEqualTo(matchCounts.get(MatchCount.FIRST));
        assertThat(matchResults.get(MatchCount.THIRD)).isEqualTo(matchCounts.get(MatchCount.THIRD));
    }
}