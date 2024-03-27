package lotto.match;

import lotto.prize.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeCountTest {

    @Test
    @DisplayName("")
    public void testGetWord() {
        LottoPrizeCount lottoPrizeCount = new LottoPrizeCount(LottoPrize.MATCH_3, 10);
        assertThat(lottoPrizeCount.getWord()).isEqualTo("3개 일치 (5000원) - 10개");
    }

}