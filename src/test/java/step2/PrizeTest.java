package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Prize;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    void 당첨통계_4개일치_상금확인() {
        int matchCount = 4;
        Prize prize = Prize.of(matchCount);
        assertThat(prize.getPrize()).isEqualTo(50000);
    }

}
