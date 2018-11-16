package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static domain.Rank.*;
import static org.assertj.core.api.Assertions.entry;

public class RankAmountTest {

    @Test
    public void 각_랭크의_갯수를_계산한다() {

        List<Lotto> attempts = Arrays.asList(
                Lotto.from(FIRST),
                Lotto.from(SECOND),
                Lotto.from(SECOND),
                Lotto.from(THIRD),
                Lotto.from(THIRD),
                Lotto.from(THIRD),
                Lotto.from(FOURTH),
                Lotto.from(FOURTH),
                Lotto.from(FOURTH)
        );

        RankAmount rankAmount = RankAmount.from(attempts);

        Assertions.assertThat(rankAmount.getRankAmount()).containsOnly(entry(FIRST, 1L),
                entry(SECOND, 2L),
                entry(THIRD, 3L),
                entry(FOURTH, 3L));
    }
}