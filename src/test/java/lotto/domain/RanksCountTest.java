package lotto.domain;

import lotto.enums.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksCountTest {

    @Test
    @DisplayName("일치하는 번호 개수에 따른 등수 카운트 추가")
    public void add() throws Exception {
        //given
        int matchedCount = 3;
        WinningRank rank = WinningRank.findByMacthedCount(matchedCount);
        RanksCount ranksCount = new RanksCount();
        RanksCount fourthRanksCount = new RanksCount();

        //when
        ranksCount.add(rank);
        fourthRanksCount.add(WinningRank.FOURTH_PLACE);

        //then
        assertThat(ranksCount).isEqualTo(fourthRanksCount);
    }

    @Test
    @DisplayName("해당하는 등수의 개수 반환")
    public void countOf() throws Exception {
        //given
        RanksCount ranksCount = new RanksCount();
        ranksCount.add(Arrays.asList(WinningRank.FIRST_PLACE, WinningRank.FIRST_PLACE, WinningRank.FIRST_PLACE));

        //when
        int count = ranksCount.countOf(WinningRank.FIRST_PLACE);

        //then
        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("총 당첨 금액 구하기")
    public void totalPrize() throws Exception {
        //given
        RanksCount ranksCount = new RanksCount();
        ranksCount.add(Arrays.asList(WinningRank.FIRST_PLACE, WinningRank.FIRST_PLACE, WinningRank.SECOND_PLACE, WinningRank.THIRD_PLACE));

        //when
        TotalPrize totalPrize = ranksCount.totalPrize();

        //then
        assertThat(totalPrize.totalPrize()).isEqualTo(2_000_000_000 + 2_000_000_000 + 1_500_000 + 50_000);
    }
}
