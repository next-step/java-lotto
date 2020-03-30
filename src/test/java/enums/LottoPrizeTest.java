package enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoPrizeTest {

    @DisplayName("매칭된 번호 개수에 맞는 상금 확인")
    @Test
    @CsvSource(value = {""})
    public void test_success_prize() throws Exception {
        //given
        final int winCount = 2;

        //then
        assertAll(
                () -> assertThat(LottoPrize.FIRST.getWinningPrize(winCount).getMoney())
                        .isEqualTo(4_000_000_000d),
                () -> assertThat(LottoPrize.SECOND.getWinningPrize(winCount).getMoney())
                        .isEqualTo(60_000_000),
                () -> assertThat(LottoPrize.THIRD.getWinningPrize(winCount).getMoney())
                        .isEqualTo(3_000_000d),
                () -> assertThat(LottoPrize.FOURTH.getWinningPrize(winCount).getMoney())
                        .isEqualTo(100_000d),
                () -> assertThat(LottoPrize.FIFTH.getWinningPrize(winCount).getMoney())
                        .isEqualTo(10_000d),
                () -> assertThat(LottoPrize.MISS.getWinningPrize(winCount).getMoney())
                        .isEqualTo(0)
        );
    }

    @DisplayName("등수별로 몇개의 당첨 번호가 확인 되야 하는지 테스트")
    @Test
    public void test_success_matchCount() throws Exception {
        assertAll(
                () -> assertThat(LottoPrize.FIRST.getMatchCount()).isEqualTo(6),
                () -> assertThat(LottoPrize.SECOND.getMatchCount()).isEqualTo(5),
                () -> assertThat(LottoPrize.THIRD.getMatchCount()).isEqualTo(5),
                () -> assertThat(LottoPrize.FOURTH.getMatchCount()).isEqualTo(4),
                () -> assertThat(LottoPrize.FIFTH.getMatchCount()).isEqualTo(3),
                () -> assertThat(LottoPrize.MISS.getMatchCount()).isEqualTo(0)
        );
    }

    @DisplayName("enum 이름이 동일한지 비교")
    @Test
    public void test_success_compareName() throws Exception {
        //given
        LottoPrize first = LottoPrize.FIRST;
        LottoPrize compare1 = LottoPrize.FIRST;
        LottoPrize compare2 = LottoPrize.SECOND;

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
        LottoPrize first1 = LottoPrize.findRank(6, false);
        LottoPrize first2 = LottoPrize.findRank(6, false);
        LottoPrize second = LottoPrize.findRank(5, true);
        LottoPrize third = LottoPrize.findRank(5, false);
        LottoPrize fourth = LottoPrize.findRank(4, false);
        LottoPrize fifth = LottoPrize.findRank(3, false);
        LottoPrize miss = LottoPrize.findRank(2, false);

        //then
        assertAll(
                () -> assertThat(first1.isEquals(LottoPrize.FIRST)).isTrue()
                , () -> assertThat(first2.isEquals(LottoPrize.FIRST)).isTrue()
                , () -> assertThat(second.isEquals(LottoPrize.SECOND)).isTrue()
                , () -> assertThat(third.isEquals(LottoPrize.THIRD)).isTrue()
                , () -> assertThat(fourth.isEquals(LottoPrize.FOURTH)).isTrue()
                , () -> assertThat(fifth.isEquals(LottoPrize.FIFTH)).isTrue()
                , () -> assertThat(miss.isEquals(LottoPrize.MISS)).isTrue()
        );
    }
}
