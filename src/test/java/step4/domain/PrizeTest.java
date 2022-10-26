package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static step4.domain.Prize.*;

class PrizeTest {
    @Test
    void 등수_확인_2등일경우() {
        Assertions.assertThat(getPrize(5,true)).isEqualTo(FIVE_BONUS_PRIZE);
    }

    @Test
    void 등수_확인_3등일경우() {
        Assertions.assertThat(getPrize(5,false)).isEqualTo(FIVE_PRIZE);
    }

    @Test
    void 등수_확인_5등일경우() {
        Assertions.assertThat(getPrize(3,false)).isEqualTo(THREE_PRIZE);
    }

    @Test
    void 등수_밖일경우() {
        Assertions.assertThat(getPrize(2,false)).isEqualTo(NONE);
    }
}