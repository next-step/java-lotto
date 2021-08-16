package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RankingTest {

    @Test
    public void 로또_보상의_범위인_5등에서부터_1등까지를_반환한다(){
        //given
        //then
        assertThat(Ranking.values()).contains(Ranking.FIFTH, Ranking.FOURTH, Ranking.THIRD, Ranking.SECOND, Ranking.FIRST);
    }
}