package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("result가 주어졌을 때 해당 결과에 맞는 당첨금이 반환되는지 검증")
    @Test
    void winningAmountTest() {
        Result result = new Result();
        result.add(Rank.FIFTH);
        result.add(Rank.FOURTH);
        result.add(Rank.THIRD);
        result.add(Rank.SECOND);
        result.add(Rank.FIRST);

        assertThat(result.calculateWinningAmount()).isEqualTo(2_004_555_000);
    }
}
