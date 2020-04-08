package enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankTest {

    @DisplayName("매칭된 번호 개수에 맞는 상금 확인")
    @Test
    @CsvSource(value = {""})
    public void test_success_prize() throws Exception {
        //given
        final int winCount = 2;

        //then
        assertAll(
                () -> assertThat(Rank.FIRST.getWinningPrize(winCount).getMoney())
                        .isEqualTo(4_000_000_000d),
                () -> assertThat(Rank.SECOND.getWinningPrize(winCount).getMoney())
                        .isEqualTo(60_000_000),
                () -> assertThat(Rank.THIRD.getWinningPrize(winCount).getMoney())
                        .isEqualTo(3_000_000d),
                () -> assertThat(Rank.FOURTH.getWinningPrize(winCount).getMoney())
                        .isEqualTo(100_000d),
                () -> assertThat(Rank.FIFTH.getWinningPrize(winCount).getMoney())
                        .isEqualTo(10_000d),
                () -> assertThat(Rank.MISS.getWinningPrize(winCount).getMoney())
                        .isEqualTo(0)
        );
    }

    @DisplayName("등수별로 몇개의 당첨 번호가 확인 되야 하는지 테스트")
    @Test
    public void test_success_matchCount() throws Exception {
        assertAll(
                () -> assertThat(Rank.FIRST.getMatchCount()).isEqualTo(6),
                () -> assertThat(Rank.SECOND.getMatchCount()).isEqualTo(5),
                () -> assertThat(Rank.THIRD.getMatchCount()).isEqualTo(5),
                () -> assertThat(Rank.FOURTH.getMatchCount()).isEqualTo(4),
                () -> assertThat(Rank.FIFTH.getMatchCount()).isEqualTo(3),
                () -> assertThat(Rank.MISS.getMatchCount()).isEqualTo(0)
        );
    }

    @DisplayName("enum 이름이 동일한지 비교")
    @Test
    public void test_success_compareName() throws Exception {
        //given
        Rank first = Rank.FIRST;
        Rank compare1 = Rank.FIRST;
        Rank compare2 = Rank.SECOND;

        //then
        assertAll(
                () -> assertThat(compare1.isEquals(compare1)).isTrue(),
                () -> assertThat(compare1.isEquals(compare2)).isFalse()
        );
    }

    @DisplayName("로또 등수 판단")
    @Test
    public void findRank_success() throws Exception {
        //given
        Rank first1 = Rank.findRank(6, false);
        Rank first2 = Rank.findRank(6, false);
        Rank second = Rank.findRank(5, true);
        Rank third = Rank.findRank(5, false);
        Rank fourth = Rank.findRank(4, false);
        Rank fifth = Rank.findRank(3, false);
        Rank miss = Rank.findRank(2, false);

        //then
        assertAll(
                () -> assertThat(first1.isEquals(Rank.FIRST)).isTrue()
                , () -> assertThat(first2.isEquals(Rank.FIRST)).isTrue()
                , () -> assertThat(second.isEquals(Rank.SECOND)).isTrue()
                , () -> assertThat(third.isEquals(Rank.THIRD)).isTrue()
                , () -> assertThat(fourth.isEquals(Rank.FOURTH)).isTrue()
                , () -> assertThat(fifth.isEquals(Rank.FIFTH)).isTrue()
                , () -> assertThat(miss.isEquals(Rank.MISS)).isTrue()
        );
    }
}
