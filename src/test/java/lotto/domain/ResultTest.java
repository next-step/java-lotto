package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    void update() {
        // given
        Rank rank = Rank.FIRST;
        Result result = new Result();

        // when
        result.update(rank);

        // then
        assertThat(result.result().get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.result().get(Rank.SECOND)).isEqualTo(0);
    }
}
