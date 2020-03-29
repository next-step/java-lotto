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
    public void prize() throws Exception {
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
    public void matchCount() throws Exception {
        assertAll(
                () -> assertThat(LottoPrize.FIRST.getMatchCount()).isEqualTo(6),
                () -> assertThat(LottoPrize.SECOND.getMatchCount()).isEqualTo(5),
                () -> assertThat(LottoPrize.THIRD.getMatchCount()).isEqualTo(5),
                () -> assertThat(LottoPrize.FOURTH.getMatchCount()).isEqualTo(4),
                () -> assertThat(LottoPrize.FIFTH.getMatchCount()).isEqualTo(3),
                () -> assertThat(LottoPrize.MISS.getMatchCount()).isEqualTo(0)
        );
    }
}
