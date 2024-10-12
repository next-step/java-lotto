package lotto.domain.prize;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningPrizeTest {

    @Test
    void 입력받은_로또_당첨_번호를_소유한_로또와_비교하여_일치_개수_정상_기록() {
        WinningPrize prize = winningPrize();

        assertThat(prize.winAmount(LottoPrize.FIRST)).isEqualTo(1);
        assertThat(prize.winAmount(LottoPrize.SECOND)).isEqualTo(1);
        assertThat(prize.winAmount(LottoPrize.SECOND_WITH_BONUS)).isEqualTo(1);
        assertThat(prize.winAmount(LottoPrize.THIRD)).isEqualTo(1);
        assertThat(prize.winAmount(LottoPrize.FOURTH)).isEqualTo(1);
    }

    private WinningPrize winningPrize() {
        WinningPrize prize = new WinningPrize();

        prize.record(LottoPrize.FIRST);
        prize.record(LottoPrize.SECOND);
        prize.record(LottoPrize.SECOND_WITH_BONUS);
        prize.record(LottoPrize.THIRD);
        prize.record(LottoPrize.FOURTH);

        return prize;
    }

    @Test
    void 입력받은_로또_당첨_번호로_상금_총액을_정상_계산() {
        WinningPrize prize = winningPrize();

        long prizeTotal = 2_000_000_000L + 30_000_000 + 1_500_000 + 50_000 + 5_000;

        assertThat(prize.totalPrize()).isEqualTo(prizeTotal);
    }
}
