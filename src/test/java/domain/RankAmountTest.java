package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.Rank.*;
import static org.assertj.core.api.Assertions.entry;

public class RankAmountTest {

    @Test
    public void 각_랭크의_갯수를_계산한다() {

        List<Attempt> attempts = Arrays.asList(
                new Attempt(FIRST),
                new Attempt(SECOND),
                new Attempt(SECOND),
                new Attempt(THIRD),
                new Attempt(THIRD),
                new Attempt(THIRD),
                new Attempt(FOURTH),
                new Attempt(FOURTH),
                new Attempt(FOURTH)
        );

        RankAmount rankAmount = new RankAmount(attempts);

        Assertions.assertThat(rankAmount.getRankAmount()).containsOnly(entry(FIRST, 1L),
                entry(SECOND, 2L),
                entry(THIRD, 3L),
                entry(FOURTH, 3L));
    }
}