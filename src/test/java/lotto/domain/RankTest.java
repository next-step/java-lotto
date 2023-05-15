package lotto.domain;

import lotto.domian.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("1등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFirst() {
        Assertions.assertThat(Rank.find(6, false)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseSecond() {
        Assertions.assertThat(Rank.find(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseThird() {
        Assertions.assertThat(Rank.find(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFourth() {
        Assertions.assertThat(Rank.find(4, false)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("5등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFIFTH() {
        Assertions.assertThat(Rank.find(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하를 맞혔을 경우 꽝이다.")
    @Test
    public void rank_DependsOnUnderCount_ThrowException() {
        Assertions.assertThat(Rank.find(2, false)).isEqualTo(Rank.MISS);
    }

}
