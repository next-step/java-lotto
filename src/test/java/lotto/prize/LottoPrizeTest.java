package lotto.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {
    @DisplayName("맞춘 로또 번호에 해당하는 당첨금을 조회할 수 있다.")
    @ParameterizedTest
    @CsvSource({"3,false,5000", "4,false,50_000", "5,false,1_500_000", "5,true,30_000_000", "6,false,2_000_000_000"})
    void getLottoPrize(int matchedCount, boolean bonusMatch, int prize) {
        assertThat(LottoPrize.getPrize(matchedCount, bonusMatch).getPrizeAmount()).isEqualTo(prize);
    }

    @DisplayName("맞은 로또 번호 갯수가 3개 이상이면 true를 반환한다.")
    @Test
    void isWinningPrize() {
        assertThat(LottoPrize.FIFTH.isWinningPrize(3)).isTrue();
        assertThat(LottoPrize.SECOND.isWinningPrize(3)).isTrue();
        assertThat(LottoPrize.THIRD.isWinningPrize(3)).isTrue();
        assertThat(LottoPrize.FOURTH.isWinningPrize(3)).isTrue();
        assertThat(LottoPrize.FIFTH.isWinningPrize(3)).isTrue();
    }

    @DisplayName("맞은 로또 번호 갯수가 4개보다 작으면 false를 반환한다.")
    @Test
    void isWinningPrizeReturnFalse() {
        assertThat(LottoPrize.FIFTH.isWinningPrize(4)).isFalse();
    }
}