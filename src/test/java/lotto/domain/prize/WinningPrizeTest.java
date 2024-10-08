package lotto.domain.prize;

import lotto.constant.LottoPrize;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningPrizeTest {

    @Test
    void 입력받은_로또_당첨_번호를_소유한_로또와_비교하여_일치_개수_정상_기록() {
        WinningPrize prize = new WinningPrize();

        prize.record(LottoPrize.FIRST.getMatch());
        prize.record(LottoPrize.SECOND.getMatch());
        prize.record(LottoPrize.THIRD.getMatch());
        prize.record(LottoPrize.THIRD.getMatch());
        prize.record(LottoPrize.FOURTH.getMatch());
        prize.record(LottoPrize.FOURTH.getMatch());

        assertThat(prize.winAmount(LottoPrize.FIRST.getMatch())).isEqualTo(1);
        assertThat(prize.winAmount(LottoPrize.SECOND.getMatch())).isEqualTo(1);
        assertThat(prize.winAmount(LottoPrize.THIRD.getMatch())).isEqualTo(2);
        assertThat(prize.winAmount(LottoPrize.FOURTH.getMatch())).isEqualTo(2);
    }
}
