package study.step2.domain.dto;

import org.junit.jupiter.api.Test;
import study.step2.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void 당첨_금액_합계() {
        Result result = new Result();
        result.add(Rank.SECOND);
        result.add(Rank.THIRD);
        result.add(Rank.THIRD);
        assertThat(result.totalWiningAmount()).isEqualTo((Rank.SECOND.amount()) + (Rank.THIRD.amount() * 2));
    }
}
