package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MatchInfoTest {

    @DisplayName("count와 bonus값으로 MatchInfof를 만들 수 있다")
    @Test
    public void should_make_object() throws Exception {
        //arrange
        MatchInfo matchInfo = getMatchInfo();

        //assert
        assertAll(
                () -> assertThat(matchInfo.isBonusNumberMatch()).isEqualTo(true),
                () -> assertEquals(matchInfo, MatchInfo.of(5, true))
        );
    }

    @DisplayName("전달된 count가 MatchInfo의 count와 동일하면 true를 반환한다")
    @Test
    public void should_return_true_equal_count() throws Exception {
        //arrange
        MatchInfo matchInfo = getMatchInfo();

        //act, assert
        assertTrue(matchInfo.isEqualCount(5));
    }

    @DisplayName("전달된 count가 MatchInfo의 count보다 작으면 false를 반환한다")
    @Test
    public void should_return_true_equal_under_count() throws Exception {
        //arrange
        MatchInfo matchInfo = getMatchInfo();

        //act, assert
        assertFalse(matchInfo.isUnderCount(3));
    }

    @DisplayName("전달된 count가 MatchInfo의 count보다 크면 true를 반환한다")
    @Test
    public void should_return_false_equal_over_count() throws Exception {
        //arrange
        MatchInfo matchInfo = getMatchInfo();

        //act, assert
        assertTrue(matchInfo.isUnderCount(6));
    }

    private MatchInfo getMatchInfo() {
        return MatchInfo.of(5, true);
    }
}