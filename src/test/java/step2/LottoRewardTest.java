package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardTest {


    @Test
    void getTotalRewardPrice() {
        LottoReward.calcMatchCount(new Lotto("1,4,23,42,43,45"), new Lotto("1,4,23,40,41,44"));
        assertThat(LottoReward.THREE_MATCH.getTotalRewardPrice()).isEqualTo(10000);
    }

    @Test
    void 로또_수익률_확인() {
        LottoReward.calcMatchCount(new Lotto("1,4,23,42,43,45"), new Lotto("1,4,23,40,41,44"));
        assertThat(LottoReward.calcYield(5000)).isEqualTo(1);
        LottoReward.calcMatchCount(new Lotto("1,4,23,40,43,45"), new Lotto("1,4,23,40,41,44"));
        assertThat(LottoReward.calcYield(5000)).isEqualTo(11);
    }
}