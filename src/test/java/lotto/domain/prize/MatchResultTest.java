package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MatchResultTest {
    @DisplayName("매치된 로또 결과가있을경우 MatchResult객체를 만든다")
    @Test
    public void should_make_object_when_match_map_isNotEmpty() throws Exception {
        //arrange
        Map<LottoPrize, Long> matchMap = new HashMap<LottoPrize, Long>() {{
                put(LottoPrize.FIRST, 1L);
        }};

        //act
        MatchResult matchResult = MatchResult.of(matchMap);

        //assert
        assertThat(matchResult.getMatchResult().size()).isEqualTo(1);
    }

    @DisplayName("매치된 로또 결과가 null이면 MatchResult객체를 만든다")
    @NullAndEmptySource
    @ParameterizedTest
    public void should_throw_exception_null_or_empty_match_map(Map<LottoPrize, Long> matchMap) throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> MatchResult.of(matchMap));
    }

    @DisplayName("매치된 로또 결과가 있을경우 match count를 반환한다")
    @Test
    public void should_get_match_count() throws Exception {
        //arrange
        Map<LottoPrize, Long> matchMap = new HashMap<LottoPrize, Long>() {{
            put(LottoPrize.FIRST, 1L);
        }};
        MatchResult matchResult = MatchResult.of(matchMap);

        //act
        int matchCount = matchResult.matchCount(LottoPrize.FIRST);

        //assert
        assertThat(matchCount).isEqualTo(1);
    }

    @DisplayName("매치된 로또 결과가 없을경우 match count를 반환한다")
    @Test
    public void should_not_get_match_count() throws Exception {
        //arrange
        Map<LottoPrize, Long> matchMap = new HashMap<LottoPrize, Long>() {{
            put(LottoPrize.FIRST, 1L);
        }};
        MatchResult matchResult = MatchResult.of(matchMap);

        //act
        int matchCount = matchResult.matchCount(LottoPrize.SECOND);

        //assert
        assertThat(matchCount).isEqualTo(0);
    }
}