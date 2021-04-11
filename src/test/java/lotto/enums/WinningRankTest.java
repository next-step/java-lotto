package lotto.enums;

import lotto.domain.MatchedCount;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRankTest {

    @Test
    @DisplayName("등수에 따른 상금 반환을 반환한다.")
    public void prize() throws Exception {
        Prize firstPrize = WinningRank.FIRST_PLACE.prize();
        assertThat(firstPrize.prize()).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("등수에 매칭되는 번호의 개수를 반환 반환한다.")
    public void MatchedCount() throws Exception {
        MatchedCount MatchedCount = WinningRank.FIRST_PLACE.matchedCount();
        assertThat(MatchedCount).isEqualTo(new MatchedCount(6));
    }

    @Test
    @DisplayName("일치하는 수와 보너스 번호를 통해 당첨 등수를 반환한다.")
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
    @DisplayName("당첨 등수가 2등일 시 참을 반환한다.")
    public void isSecondPlace() throws Exception {
        assertThat(WinningRank.SECOND_PLACE.isSecondPlace(true)).isTrue();
        assertThat(WinningRank.SECOND_PLACE.isSecondPlace(false)).isFalse();
    }

    @Test
    @DisplayName("5등의 일치하는 번호 개수 3보다 작을 경우 참을 반환한다.")
    public void hasGreaterThan() throws Exception {
        assertThat(WinningRank.FIFTH_PLACE.hasGreaterThan(new MatchedCount(3))).isFalse();
        assertThat(WinningRank.FIFTH_PLACE.hasGreaterThan(new MatchedCount(2))).isTrue();
    }
}
