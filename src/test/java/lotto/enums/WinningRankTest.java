package lotto.enums;

import lotto.domain.RanksCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRankTest {

    @Test
    @DisplayName("상금 반환")
    public void prize() throws Exception {
        int firstPrize = WinningRank.FIRST_PLACE.prize();
        assertThat(firstPrize).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("일치하는 수 반환")
    public void MatchedCount() throws Exception {
        int MatchedCount = WinningRank.FIRST_PLACE.matchedCount();
        assertThat(MatchedCount).isEqualTo(6);
    }

    @Test
    @DisplayName("일치하는 수에 따른 타입 반환")
    public void findByMacthedCount() throws Exception {
        WinningRank firstPlace = WinningRank.findByMacthedCount(6);
        WinningRank etc = WinningRank.findByMacthedCount(2);
        assertThat(firstPlace).isEqualTo(WinningRank.FIRST_PLACE);
        assertThat(etc).isEqualTo(WinningRank.ETC);
    }

    @Test
    public void totalPrize() throws Exception {
        //given
        RanksCount ranksCount = new RanksCount();
        ranksCount.add(Arrays.asList(WinningRank.FIRST_PLACE, WinningRank.FIRST_PLACE, WinningRank.SECOND_PLACE, WinningRank.THIRD_PLACE));

        //when
        int totalPrize = WinningRank.totalPrize(ranksCount);

        //then
        assertThat(totalPrize).isEqualTo(2_000_000_000 + 2_000_000_000 + 1_500_000 + 50_000);
    }
}
