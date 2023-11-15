package study.step2.domain.dto;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import study.step2.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void 당첨_금액_합계() {
        int winningAmount = Result.sumWinningAmount(
            Arrays.asList(
                new Result(Rank.SECOND, 1),
                new Result(Rank.THIRD, 2)
            )
        );
        assertThat(winningAmount).isEqualTo((Rank.SECOND.amount()) + (Rank.THIRD.amount() * 2));
    }
}
