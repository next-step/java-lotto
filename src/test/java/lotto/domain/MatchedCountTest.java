package lotto.domain;

import lotto.enums.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MatchedCountTest {

    @Test
    @DisplayName("매칭된 수 객체 생성")
    public void create() throws Exception {
        MatchedCount matchedCount = new MatchedCount(3);
        assertThat(matchedCount).isEqualTo(new MatchedCount(3));
    }

    @Test
    @DisplayName("매칭된 개수가 0~ 6 범위가 아닐 경우 예외")
    public void validateBound() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new MatchedCount(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> new MatchedCount(7));
    }

    @Test
    @DisplayName("매칭된 개수가 크거나 같은 경우")
    public void isGreaterOrEqualThan() throws Exception {
        assertThat(WinningRank.FIRST_PLACE.matchedCount().isGreaterOrEqualThan(5)).isTrue();
        assertThat(WinningRank.SECOND_PLACE.matchedCount().isGreaterOrEqualThan(6)).isFalse();
    }
}
