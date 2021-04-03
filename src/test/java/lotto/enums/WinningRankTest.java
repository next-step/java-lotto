package lotto.enums;

import lotto.domain.MatchedCount;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningRankTest {

    @Test
    @DisplayName("상금 반환")
    public void prize() throws Exception {
        Prize firstPrize = WinningRank.FIRST_PLACE.prize();
        assertThat(firstPrize.prize()).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("일치하는 수 반환")
    public void MatchedCount() throws Exception {
        MatchedCount MatchedCount = WinningRank.FIRST_PLACE.matchedCount();
        assertThat(MatchedCount).isEqualTo(new MatchedCount(6));
    }

    @Test
    @DisplayName("일치하는 수에 따른 타입 반환")
    public void findByMacthedCount() throws Exception {
        WinningRank firstPlace = WinningRank.findByMacthedCount(6, false);
        WinningRank secondPlace = WinningRank.findByMacthedCount(5, true);
        WinningRank thirdPlace = WinningRank.findByMacthedCount(5, false);
        WinningRank etc = WinningRank.findByMacthedCount(2, false);
        assertThat(firstPlace).isEqualTo(WinningRank.FIRST_PLACE);
        assertThat(secondPlace).isEqualTo(WinningRank.SECOND_PLACE);
        assertThat(thirdPlace).isEqualTo(WinningRank.THIRD_PLACE);
        assertThat(etc).isEqualTo(WinningRank.ETC);
    }

    @Test
    @DisplayName("2등인지 판별")
    public void isSecondPlace() throws Exception {
        assertThat(WinningRank.SECOND_PLACE.isSecondPlace(true)).isTrue();
        assertThat(WinningRank.SECOND_PLACE.isSecondPlace(false)).isFalse();
    }
}
