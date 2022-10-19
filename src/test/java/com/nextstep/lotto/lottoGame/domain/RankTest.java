package com.nextstep.lotto.lottoGame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankTest {

    @Test
    public void rank() {
        assertThat(Rank.rank(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.rank(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.rank(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.rank(3)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void rank_invalid() {
        assertThatThrownBy(() ->{
            Rank.rank(7);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
