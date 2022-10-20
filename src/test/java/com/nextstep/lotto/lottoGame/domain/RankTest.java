package com.nextstep.lotto.lottoGame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankTest {

    @Test
    public void rank() {
        assertThat(Rank.rank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.rank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.rank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.rank(4, true)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void rank_invalid() {
        assertThatThrownBy(() ->{
            Rank.rank(7, false);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
